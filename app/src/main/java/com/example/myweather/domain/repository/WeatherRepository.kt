package com.example.myweather.domain.repository

import com.example.myweather.domain.model.UserLocation
import com.example.myweather.domain.model.Weather


interface WeatherRepository {

    suspend fun getWeatherDataFromApi(lat: Double, long: Double): Weather

    suspend fun getUsersLocation(): UserLocation

    suspend fun getCityByLocation(lat: Double, long: Double): String
}