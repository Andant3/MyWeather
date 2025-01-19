package com.example.myweather.presentation.state

import com.example.myweather.domain.model.DailyWeather
import com.example.myweather.domain.model.HourlyWeather

data class WeatherState(
    val isLoading: Boolean = true,
    val city: String = UNDEFINED_CITY,
    val hourlyWeather: HourlyWeather = HourlyWeather(),
    val dailyWeather: DailyWeather = DailyWeather(),
    val selectedDay: Int = UNDEFINED_DAY
    ){
    companion object{
        const val UNDEFINED_CITY = ""
        const val UNDEFINED_DAY = 0
    }
}
