package com.example.myweather.domain.usecases

import com.example.myweather.domain.model.UserLocation
import com.example.myweather.domain.repository.WeatherRepository

class GetUsersLocation(private val repository: WeatherRepository) {

    suspend fun invoke(): UserLocation{
        return repository.getUsersLocation()
    }
}