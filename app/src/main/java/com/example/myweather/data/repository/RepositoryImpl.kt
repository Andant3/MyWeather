package com.example.myweather.data.repository

import com.example.myweather.data.retrofit.RetrofitInstance
import com.example.myweather.domain.model.WeatherResponse
import com.example.myweather.domain.repository.Repository

class RepositoryImpl : Repository {

    override suspend fun getWeatherDataFromApi(lat: Double, long: Double): WeatherResponse {
        return RetrofitInstance.api.getWeatherFromApi(
            latitude = lat,
            longitude = long/*,
            weather_code_daily = WeatherService.WEATHER_CODE_PARAMETER,
            temperature_2m = WeatherService.TEMPERATURE_2M_PARAMETER,
            wind_speed = WeatherService.WIND_SPEED_PARAMETER,
            weather_code_hourly = WeatherService.WEATHER_CODE_PARAMETER,
            temperature_2m_max = WeatherService.TEMPERATURE_2M_PARAMETER_MAX,
            wind_speed_max = WeatherService.WIND_SPEED_PARAMETER_MAX*/
        )
    }
}