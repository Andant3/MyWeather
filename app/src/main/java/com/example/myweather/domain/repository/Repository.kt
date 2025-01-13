package com.example.myweather.domain.repository

import com.example.myweather.domain.model.WeatherResponse


interface Repository {

    suspend fun getWeatherDataFromApi(lat: Double, long: Double): WeatherResponse
}