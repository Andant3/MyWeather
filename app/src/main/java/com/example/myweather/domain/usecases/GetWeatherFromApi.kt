package com.example.myweather.domain.usecases

import com.example.myweather.domain.model.Weather
import com.example.myweather.domain.repository.WeatherRepository

class GetWeatherFromApi(private val repository: WeatherRepository) {

    suspend operator fun invoke(latitude: Double, longitude: Double): Weather {
        return repository.getWeatherDataFromApi(latitude, longitude)
    }
}