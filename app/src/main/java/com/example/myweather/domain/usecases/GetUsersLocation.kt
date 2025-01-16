package com.example.myweather.domain.usecases

import androidx.compose.runtime.MutableState
import com.example.myweather.domain.model.UserLocation
import com.example.myweather.domain.repository.WeatherRepository

class GetUsersLocation(private val repository: WeatherRepository) {

    suspend operator fun invoke(): UserLocation{
        return repository.getUsersLocation()
    }
}