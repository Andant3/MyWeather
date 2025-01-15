package com.example.myweather.presentation.state


data class WeatherState(
    val hourlyTime: List<String> = listOf(""),
    val hourly2MTemperatureList: List<Double> = emptyList(),
    val hourlyMaxWindSpeedList: List<Double> = emptyList(),
    val hourlyWeatherCodes: List<Int> = emptyList(),
    val dailyTime: List<String> = listOf(""),
    val dailyMaxTemperatureList: List<Double> = emptyList(),
    val dailyMaxWindSpeedList: List<Double> = emptyList(),
    val dailyWeatherCodes: List<Int> = emptyList()

)
