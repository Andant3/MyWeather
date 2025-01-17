package com.example.myweather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myweather.R

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
                0 -> {
                    if (time > 18) {
                        R.drawable.night_clear
                    } else {
                        R.drawable.day_clear
                    }
                }

                1, 2 -> {
                    if (time > 18) {
                        R.drawable.night_pt_cloudy
                    } else {
                        R.drawable.day_pt_cloudy
                    }
                }

                3 -> {
                    R.drawable.cloudy
                }

                45, 48 -> {
                    R.drawable.fog
                }

                61, 63 -> {
                    R.drawable.rain
                }

                65, 66, 67, 80, 81, 82 -> {
                    R.drawable.rain_wind
                }

                71, 73, 75, 77, 85, 86 -> {
                    R.drawable.snow
                }

                95, 96, 99 -> {
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