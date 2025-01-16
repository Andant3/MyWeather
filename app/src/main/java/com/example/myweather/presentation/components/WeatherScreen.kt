package com.example.myweather.presentation.components

import android.Manifest
import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myweather.domain.model.WeatherCode
import com.example.myweather.presentation.viewmodel.WeatherViewModel
import com.example.myweather.ui.theme.DarkBlueNight
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

    val backgroundColor = Color.White

    viewModel.getWeatherInfo()

    val weather = viewModel.state.value
    val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    if (fineLocationPermissionState.status.isGranted
        || coarseLocationPermissionState.status.isGranted
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(
                    when (weather.hourlyWeatherCodes[currentTime]) {
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
                        WeatherCode.VIOLENT_RAIN_SHOWERS
                             //TODO()
                                -> {
                            DarkBlueNight
                        }
                        else->{
                            Color.White
                        }
                    }
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 60.dp),
                text = weather.city,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            WeatherImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(220.dp)
                    .padding(top = 80.dp),
                weatherCode =
                if (weather.isLoading) 3
                else weather.hourlyWeatherCodes[currentTime],

                time = currentTime
            )
            WeatherText(
                modifier = Modifier
                    .padding(top = 40.dp),
                weatherCode =
                if (weather.isLoading) -1
                else weather.hourlyWeatherCodes[currentTime]
            )
        }
    } else {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Waiting for Location Permission\n" +
                        "You can change it in your Settings",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    }
}