package com.example.myweather.domain.model

import com.google.gson.annotations.SerializedName

data class HourlyWeather(
    val time: List<String> = Weather.UNDEFINED_TIME,
    @SerializedName("temperature_2m")
    val temperature2M: List<Double> = Weather.UNDEFINED_TEMPERATURE,
    @SerializedName("wind_speed_10m")
    val windSpeedMax: List<Double> = Weather.UNDEFINED_WIND_SPEED,
    @SerializedName("weather_code")
    val weatherCodes: List<Int> = Weather.UNDEFINED_WEATHER_CODE
)