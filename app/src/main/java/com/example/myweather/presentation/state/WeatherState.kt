package com.example.myweather.presentation.state


data class WeatherState(
    val isLoading: Boolean = true,
    val city: String = "",
    val hourlyTime: List<String> = listOf(""),
    val hourly2MTemperatureList: List<Double> = listOf(0.0),
    val hourlyMaxWindSpeedList: List<Double> = listOf(0.0),
    val hourlyWeatherCodes: List<Int> = listOf(0),
    val dailyTime: List<String> = listOf(""),
    val dailyMaxTemperatureList: List<Double> = listOf(0.0),
    val dailyMaxWindSpeedList: List<Double> = listOf(0.0),
    val dailyWeatherCodes: List<Int> = listOf(0)

)
