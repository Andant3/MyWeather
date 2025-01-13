package com.example.myweather.domain.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class HourlyWeather(
    val time: List<Date>,
    @SerializedName("temperature_2m_max")
    val temperatureMax: List<Double>,
    @SerializedName("wind_speed_10m")
    val windSpeedMax: List<Double>,
    @SerializedName("weather_code")
    val weatherCode: List<Int>
) {
}