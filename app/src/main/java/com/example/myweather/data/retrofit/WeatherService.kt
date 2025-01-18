package com.example.myweather.data.retrofit

import com.example.myweather.domain.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getWeatherFromApi(
        @Query("latitude")
        latitude: Double,
        @Query("longitude")
        longitude: Double,
        @Query("hourly")
        temperature_2m: String = TEMPERATURE_2M_PARAMETER,
        @Query("hourly")
        wind_speed: String = WIND_SPEED_PARAMETER,
        @Query("hourly")
        weather_code_hourly: String = WEATHER_CODE_PARAMETER,
        @Query("daily")
        temperature_2m_max: String = TEMPERATURE_2M_PARAMETER_MAX,
        @Query("daily")
        wind_speed_max: String = WIND_SPEED_PARAMETER_MAX,
        @Query("daily")
        weather_code_daily: String = WEATHER_CODE_PARAMETER
    ): Weather

    companion object {
        const val WEATHER_CODE_PARAMETER = "weather_code"
        const val WIND_SPEED_PARAMETER = "wind_speed_10m"
        const val TEMPERATURE_2M_PARAMETER = "temperature_2m"
        const val WIND_SPEED_PARAMETER_MAX = "wind_speed_10m_max"
        const val TEMPERATURE_2M_PARAMETER_MAX = "temperature_2m_max"
    }
}