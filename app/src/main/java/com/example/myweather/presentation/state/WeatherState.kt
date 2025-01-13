package com.example.myweather.presentation.state

import kotlinx.datetime.*



data class WeatherState(
    val hourlyTime: LocalDate = LocalDate.Formats.ISO.parse("2001-05-02"),
    val hourlyMaxTemperatureList: List<Double> = emptyList(),
    val hourlyMaxWindSpeedList: List<Double> = emptyList(),
    val hourlyWeatherCodes: List<Int> = emptyList(),
    val dailyTime: LocalDate = LocalDate.Formats.ISO.parse("2001-05-02"),
    val dailyMaxTemperatureList: List<Double> = emptyList(),
    val dailyMaxWindSpeedList: List<Double> = emptyList(),
    val dailyWeatherCodes: List<Int> = emptyList()

)
