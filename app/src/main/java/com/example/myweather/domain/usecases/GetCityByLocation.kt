package com.example.myweather.domain.usecases

import com.example.myweather.domain.repository.WeatherRepository

class GetCityByLocation(private val repository: WeatherRepository) {

    suspend operator fun invoke(latitude: Double, longitude: Double): String{
        return repository.getCityByLocation(latitude, longitude)
    }
}