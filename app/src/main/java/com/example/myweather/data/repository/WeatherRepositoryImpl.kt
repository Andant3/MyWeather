package com.example.myweather.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.example.myweather.data.retrofit.RetrofitInstance
import com.example.myweather.data.retrofit.WeatherService
import com.example.myweather.domain.model.UserLocation
import com.example.myweather.domain.model.WeatherResponse
import com.example.myweather.domain.repository.WeatherRepository
import com.google.android.gms.location.LocationServices

class WeatherRepositoryImpl (private val context: Context) : WeatherRepository {

    override suspend fun getWeatherDataFromApi(lat: Double, long: Double): WeatherResponse {
        return RetrofitInstance.api.getWeatherFromApi(
            latitude = lat,
            longitude = long,
            weather_code_daily = WeatherService.WEATHER_CODE_PARAMETER,
            temperature_2m = WeatherService.TEMPERATURE_2M_PARAMETER,
            wind_speed = WeatherService.WIND_SPEED_PARAMETER,
            weather_code_hourly = WeatherService.WEATHER_CODE_PARAMETER,
            temperature_2m_max = WeatherService.TEMPERATURE_2M_PARAMETER_MAX,
            wind_speed_max = WeatherService.WIND_SPEED_PARAMETER_MAX
        )
    }

    @SuppressLint("MissingPermission")
    override suspend fun getUsersLocation(): UserLocation {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        var latitude = 0.0
        var longitude = 0.0
        fusedLocationClient.lastLocation
            .addOnSuccessListener {location ->
                latitude = location.latitude
                longitude = location.longitude
        }

        return UserLocation(latitude = latitude, longitude = longitude)
    }
}