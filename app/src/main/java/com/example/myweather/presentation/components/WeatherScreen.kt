package com.example.myweather.presentation.components

import android.Manifest
import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myweather.domain.model.DailyWeather
import com.example.myweather.domain.model.HourlyWeather
import com.example.myweather.domain.model.WeatherCode
import com.example.myweather.presentation.viewmodel.WeatherViewModel
import com.example.myweather.ui.theme.DarkBlueNight
import com.example.myweather.ui.theme.OrangeSun
import com.example.myweather.ui.theme.PurpleEvening
import com.example.myweather.ui.theme.YellowMorning
import com.example.myweather.ui.theme.YellowMorningContrast
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {

    val coarseLocationPermissionState =
        rememberPermissionState(Manifest.permission.ACCESS_COARSE_LOCATION)
    val fineLocationPermissionState =
        rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)


    viewModel.getWeatherInfo()

    val weather = viewModel.state.value
    val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    val backgroundColor = if (!weather.isLoading) {
        getPrimaryBackgroundColor(
            weather.hourlyWeatherCodes[currentTime],
            currentTime
        )
    } else {
        Color.White
    }
    val textColor = getTextColor(backgroundColor)

    if (fineLocationPermissionState.status.isGranted
                || coarseLocationPermissionState.status.isGranted
    ) {
        if(!weather.isLoading){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(backgroundColor),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(top = 60.dp),
                    text = weather.city,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = textColor
                )
                WeatherImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(220.dp)
                        .padding(top = 80.dp),
                    weatherCode = weather.hourlyWeatherCodes[currentTime],
                    time = currentTime
                )

                Spacer(Modifier.height(80.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        modifier = Modifier.padding(start = 25.dp),
                        text = "${weather.hourly2MTemperatureList[currentTime].toInt()}°",
                        fontSize = 80.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                    Column(
                        modifier = Modifier.padding(start = 40.dp)
                    ) {
                        WeatherText(
                            modifier = Modifier.padding(top = 16.dp),
                            weatherCode = weather.hourlyWeatherCodes[0],
                            textColor = textColor,
                            fontSize = 22.sp
                        )
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "Wind is "
                                    + "${weather.hourlyMaxWindSpeedList[currentTime]}"
                                    + "km/h",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Hourly Weather",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
                HourlyWeatherRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(124.dp),
                    hourlyWeather = HourlyWeather(
                        time = weather.hourlyTime,
                        temperature2M = weather.hourly2MTemperatureList,
                        windSpeedMax = weather.hourlyMaxWindSpeedList,
                        weatherCodes = weather.hourlyWeatherCodes
                    ),
                    textColor = textColor,
                    backgroundColor = getSecondaryBackgroundColor(backgroundColor)
                )

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Daily Weather",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
                DailyWeatherRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(124.dp),
                    dailyWeather = DailyWeather(
                        time = weather.dailyTime,
                        temperatureMax = weather.dailyMaxTemperatureList,
                        windSpeedMax = weather.dailyMaxWindSpeedList,
                        weatherCodes = weather.dailyWeatherCodes
                    ),
                    currentTime = currentTime,
                    textColor = textColor,
                    backgroundColor = getSecondaryBackgroundColor(backgroundColor),
                    currentDay = currentDay
                )
            }
        }
        else{
            Column(
                Modifier
                    .fillMaxSize()
                    .background(DarkBlueNight),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                )
            }
        }

    } else {
        Column(
            Modifier
                .fillMaxSize()
                .background(DarkBlueNight),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Waiting for Location Permission\n" +
                        "You can change it in your Settings",
                fontWeight = FontWeight.Bold,
                color = YellowMorning
            )
        }
    }
}

private fun getPrimaryBackgroundColor(weatherCode: Int, currentTime: Int): Color {

    return when (weatherCode) {
        WeatherCode.FOG,
        WeatherCode.DEPOSITING_RIME_FOG,
        WeatherCode.OVERCAST,
        WeatherCode.LIGHT_DRIZZLE,
        WeatherCode.MODERATE_DRIZZLE,
        WeatherCode.DENSE_DRIZZLE,
        WeatherCode.SLIGHT_RAIN,
        WeatherCode.MODERATE_RAIN,
        WeatherCode.HEAVY_RAIN,
        WeatherCode.LIGHT_FREEZING_RAIN,
        WeatherCode.HEAVY_FREEZING_RAIN,
        WeatherCode.LIGHT_FREEZING_DRIZZLE,
        WeatherCode.DENSE_FREEZING_DRIZZLE,
        WeatherCode.SLIGHT_SNOW_FALL,
        WeatherCode.MODERATE_SNOW_FALL,
        WeatherCode.HEAVY_SNOW_FALL,
        WeatherCode.SNOW_GRAINS,
        WeatherCode.SLIGHT_RAIN_SHOWERS,
        WeatherCode.MODERATE_RAIN_SHOWERS,
        WeatherCode.VIOLENT_RAIN_SHOWERS,
        WeatherCode.SLIGHT_SNOW_SHOWERS,
        WeatherCode.HEAVY_SNOW_SHOWERS,
        WeatherCode.MODERATE_THUNDERSTORM,
        WeatherCode.SLIGHT_HAIL_THUNDERSTORM,
        WeatherCode.HEAVY_HAIL_THUNDERSTORM -> {
            DarkBlueNight
        }

        WeatherCode.CLEAR,
        WeatherCode.MAINLY_CLEAR,
        WeatherCode.PARTLY_CLOUDY -> {
            when (currentTime) {
                in 5..16 -> {
                    YellowMorning
                }

                in 17..18 -> {
                    OrangeSun
                }

                in 18..21 -> {
                    PurpleEvening
                }

                in 21..24 -> {
                    DarkBlueNight
                }

                in 0..4 -> {
                    DarkBlueNight
                }

                else -> {
                    Color.White

                }
            }
        }

        else -> {
            Color.White
        }
    }
}

private fun getSecondaryBackgroundColor(backgroundColor: Color): Color{

    return when(backgroundColor){
        YellowMorning -> {
            YellowMorningContrast
        }
        OrangeSun -> {
            PurpleEvening
        }
        PurpleEvening -> {
            YellowMorning
        }
        DarkBlueNight -> {
            YellowMorning
        }
        else -> {
            DarkBlueNight
        }
    }
}

private fun getTextColor(color: Color): Color {
    return when (color) {
        YellowMorning,
        OrangeSun -> {
            DarkBlueNight
        }

        DarkBlueNight,
        PurpleEvening -> {
            YellowMorning
        }

        else -> {
            Color.Black
        }
    }
}