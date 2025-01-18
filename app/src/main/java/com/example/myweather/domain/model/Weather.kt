package com.example.myweather.domain.model

data class Weather(
    val hourly: HourlyWeather,
    val daily: DailyWeather
){
    companion object{
        val UNDEFINED_TIME = listOf("0")
        val UNDEFINED_TEMPERATURE = listOf(0.0)
        val UNDEFINED_WIND_SPEED = listOf(0.0)
        val UNDEFINED_WEATHER_CODE = listOf(0)
    }
}
