package com.example.myweather.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.datetime.LocalDate

data class HourlyWeather(
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temperature2M: List<Double>,
    @SerializedName("wind_speed_10m")
    val windSpeedMax: List<Double>,
    @SerializedName("weather_code")
    val weatherCodes: List<Int>
) {
}