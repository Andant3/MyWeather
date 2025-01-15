package com.example.myweather.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.datetime.LocalDate

data class DailyWeather(
    val time: List<String>,
    @SerializedName("temperature_2m_max")
    val temperatureMax: List<Double>,
    @SerializedName("wind_speed_10m_max")
    val windSpeedMax: List<Double>,
    @SerializedName("weather_code")
    val weatherCodes: List<Int>
) {
}