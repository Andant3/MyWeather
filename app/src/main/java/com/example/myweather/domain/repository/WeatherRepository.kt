package com.example.myweather.domain.repository

import com.example.myweather.domain.model.UserLocation
import com.example.myweather.domain.model.WeatherResponse


interface WeatherRepository {

    suspend fun getWeatherDataFromApi(lat: Double, long: Double): WeatherResponse

    suspend fun getUsersLocation(): UserLocation
}