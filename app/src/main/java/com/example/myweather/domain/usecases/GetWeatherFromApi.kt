package com.example.myweather.domain.usecases

import com.example.myweather.domain.model.WeatherResponse
import com.example.myweather.domain.repository.Repository

class GetWeatherFromApi(private val repository: Repository) {

    suspend fun invoke(lat: Double, long: Double): WeatherResponse {
        return repository.getWeatherDataFromApi(lat, long)
    }
}