package com.example.myweather.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.domain.model.HourlyWeather


@Composable
fun HourlyWeatherRow(
    modifier: Modifier,
    hourlyWeather: HourlyWeather,
    textColor: Color,
    backgroundColor: Color
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        LazyRow(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 12.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(24) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(bottom = 6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$index:00",
                        fontSize = 10.sp,
                        color = textColor
                    )
                    WeatherImage(
                        modifier = Modifier.padding(top = 6.dp),
                        weatherCode = hourlyWeather.weatherCodes[index],
                        time = index
                    )
                    Text(
                        modifier = Modifier,
                        text = hourlyWeather.temperature2M[index]
                            .toInt().toString() + "°",
                        fontSize = 10.sp,
                        color = textColor
                    )
                }
            }
        }
    }
}