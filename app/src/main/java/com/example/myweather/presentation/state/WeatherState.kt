package com.example.myweather.presentation.state

import com.example.myweather.domain.model.DailyWeather
import com.example.myweather.domain.model.HourlyWeather

data class WeatherState(
    val isLoading: Boolean = true,
    val city: String = "",
    val hourlyWeather: HourlyWeather = HourlyWeather(),
    val dailyWeather: DailyWeather = DailyWeather()
    )
