package com.example.myweather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myweather.R
import com.example.myweather.domain.model.WeatherCode

@Composable
fun WeatherImage(
    modifier: Modifier,
    weatherCode: Int,
    time: Int
) {

    Image(
        modifier = modifier,
        painter = painterResource(
            when (weatherCode) {
                WeatherCode.CLEAR -> {
                    if (time > 18 || time < 5) {
                        R.drawable.night_clear
                    } else {
                        R.drawable.day_clear
                    }
                }

                WeatherCode.MAINLY_CLEAR,
                WeatherCode.PARTLY_CLOUDY-> {
                    if (time > 18 || time < 5) {
                        R.drawable.night_pt_cloudy
                    } else {
                        R.drawable.day_pt_cloudy
                    }
                }

                WeatherCode.OVERCAST -> {
                    R.drawable.cloudy
                }

                WeatherCode.FOG,
                WeatherCode.DEPOSITING_RIME_FOG -> {
                    R.drawable.fog
                }

                WeatherCode.LIGHT_DRIZZLE,
                WeatherCode.MODERATE_DRIZZLE,
                WeatherCode.DENSE_DRIZZLE,
                WeatherCode.LIGHT_FREEZING_DRIZZLE,
                WeatherCode.DENSE_FREEZING_DRIZZLE->{
                    R.drawable.rain_wind
                }

                WeatherCode.SLIGHT_RAIN,
                WeatherCode.MODERATE_RAIN -> {
                    R.drawable.rain
                }

                WeatherCode.HEAVY_RAIN,
                WeatherCode.LIGHT_FREEZING_RAIN,
                WeatherCode.HEAVY_FREEZING_RAIN,
                WeatherCode.SLIGHT_RAIN_SHOWERS,
                WeatherCode.MODERATE_RAIN_SHOWERS,
                WeatherCode.VIOLENT_RAIN_SHOWERS -> {
                    R.drawable.rain_wind
                }

                WeatherCode.SLIGHT_SNOW_FALL,
                WeatherCode.MODERATE_SNOW_FALL,
                WeatherCode.HEAVY_SNOW_FALL,
                WeatherCode.SNOW_GRAINS,
                WeatherCode.SLIGHT_SNOW_SHOWERS,
                WeatherCode.HEAVY_SNOW_SHOWERS -> {
                    R.drawable.snow
                }

                WeatherCode.MODERATE_THUNDERSTORM,
                WeatherCode.SLIGHT_HAIL_THUNDERSTORM,
                WeatherCode.HEAVY_HAIL_THUNDERSTORM -> {
                    R.drawable.thunderstorm
                }

                else -> {
                    (R.drawable.cloudy)
                }

            }
        ),
        contentDescription = "Weather Image"
    )
}