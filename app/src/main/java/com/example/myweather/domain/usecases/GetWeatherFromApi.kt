package com.example.myweather.domain.usecases

import com.example.myweather.domain.model.WeatherResponse
import com.example.myweather.domain.repository.WeatherRepository

class GetWeatherFromApi(private val repository: WeatherRepository) {

    suspend fun invoke(latitude: Double, longitude: Double): WeatherResponse {
        return repository.getWeatherDataFromApi(latitude, longitude)
    }
}