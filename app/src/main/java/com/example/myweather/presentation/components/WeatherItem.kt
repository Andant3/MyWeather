package com.example.myweather.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherItem(
    modifier: Modifier,
    dayOfTheWeek: String,
    dayNumber: Int,
    bottomText: String,
    textColor: Color,
    backgroundColor: Color,
    currentTime: Int,
    weatherCode: Int,
    onClick: (day: Int) -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        onClick = {onClick(dayNumber)}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = dayOfTheWeek,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )

                WeatherImage(
                    modifier = Modifier,
                    weatherCode = weatherCode,
                    time = currentTime
                )
                Text(
                    text = bottomText,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }
        }
    }
}