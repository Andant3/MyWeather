package com.example.myweather.domain.model

data class WeatherResponse(
    val hourly: HourlyWeather,
    val daily: DailyWeather
) {

}
