package com.example.myweather.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myweather.domain.model.DailyWeather
import kotlinx.datetime.DayOfWeek

@Composable
fun DailyWeatherRow(
    modifier: Modifier,
    dailyWeather: DailyWeather,
    currentTime: Int,
    dayOfTheWeek: Int,
    textColor: Color,
    backgroundColor: Color,
    secondaryBackgroundColor: Color,
    onClick: (day: Int) -> Unit
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = secondaryBackgroundColor
        )
    ) {
        LazyRow(
            modifier = Modifier
                .padding(
                    12.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(7) { index ->
                WeatherItem(
                    modifier = Modifier
                        .width(80.dp)
                        .height(160.dp)
                        .padding(
                            top = 6.dp,
                            bottom = 6.dp
                        ),
                    dayOfTheWeek = DayOfWeek.of(
                        if ((dayOfTheWeek + index) != 7) (dayOfTheWeek + index) % 7
                        else 7
                    ).toString().substring(0, 3),
                    textColor = textColor,
                    bottomText = dailyWeather.temperatureMax[index]
                        .toInt().toString() + "°",
                    currentTime = currentTime,
                    weatherCode = dailyWeather.weatherCodes[index],
                    backgroundColor = backgroundColor,
                    dayNumber = index,
                    onClick = onClick
                )
            }
        }
    }
}