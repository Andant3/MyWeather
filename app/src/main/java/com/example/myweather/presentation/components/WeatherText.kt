package com.example.myweather.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.myweather.domain.model.WeatherCode

@Composable
fun WeatherText(
    modifier: Modifier,
    weatherCode: Int,
    textColor: Color,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = when (weatherCode) {
            WeatherCode.CLEAR -> "Clear"

            WeatherCode.MAINLY_CLEAR -> "Mainly Clear"

            WeatherCode.PARTLY_CLOUDY -> "Partly Cloudy"

            WeatherCode.OVERCAST -> "Overcast"

            WeatherCode.FOG,
            WeatherCode.DEPOSITING_RIME_FOG -> "Fog"

            WeatherCode.LIGHT_DRIZZLE,
            WeatherCode.MODERATE_DRIZZLE,
            WeatherCode.DENSE_DRIZZLE -> "Drizzle"

            WeatherCode.LIGHT_FREEZING_DRIZZLE,
            WeatherCode.DENSE_FREEZING_DRIZZLE -> "Freezing Drizzle"

            WeatherCode.SLIGHT_RAIN,
            WeatherCode.MODERATE_RAIN,
            WeatherCode.HEAVY_RAIN -> "Rain"

            WeatherCode.LIGHT_FREEZING_RAIN,
            WeatherCode.HEAVY_FREEZING_RAIN -> "Freezing Rain"

            WeatherCode.SLIGHT_SNOW_FALL,
            WeatherCode.MODERATE_SNOW_FALL,
            WeatherCode.HEAVY_SNOW_FALL -> "Snow fall"

            WeatherCode.SNOW_GRAINS -> "Snow Grains"

            WeatherCode.SLIGHT_RAIN_SHOWERS,
            WeatherCode.MODERATE_RAIN_SHOWERS,
            WeatherCode.VIOLENT_RAIN_SHOWERS -> "Rain Showers"

            WeatherCode.SLIGHT_SNOW_SHOWERS,
            WeatherCode.HEAVY_SNOW_SHOWERS -> "Snow Showers"

            WeatherCode.MODERATE_THUNDERSTORM,
            WeatherCode.SLIGHT_HAIL_THUNDERSTORM,
            WeatherCode.HEAVY_HAIL_THUNDERSTORM -> "Thunderstorm"

            else -> {
                "Undefined"
            }
        },
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        color = textColor
    )
}