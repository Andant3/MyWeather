package com.example.myweather.presentation.state

import com.example.myweather.domain.model.DailyWeather
import com.example.myweather.domain.model.HourlyWeather

data class WeatherState(
    val isLoading: Boolean = true,
    var isRefreshing: Boolean = false,
    val city: String = UNDEFINED_CITY,
    val selectedDay: Int = DEFAULT_DAY,
    val hourlyWeather: HourlyWeather = HourlyWeather(),
    val dailyWeather: DailyWeather = DailyWeather()
    ){
    companion object{
        const val UNDEFINED_CITY = ""
        const val DEFAULT_DAY = 0
    }
}
