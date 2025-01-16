package com.example.myweather.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweather.domain.usecases.WeatherUseCases
import com.example.myweather.presentation.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCases: WeatherUseCases
) : ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state


    fun getWeatherInfo() {
        viewModelScope.launch {
            try {
                val usersLocation = weatherUseCases.getUsersLocation.invoke()
                val weatherResponse = weatherUseCases
                    .getWeatherFromApi.invoke(
                        latitude = usersLocation.latitude,
                        longitude = usersLocation.longitude
                    )

                Log.i(
                    "TAGY", "Location is successfully loaded" +
                            "\nlatitude = ${usersLocation.latitude}" +
                            "\nlongitude = ${usersLocation.longitude}"
                )

                val city = weatherUseCases.getCityByLocation.invoke(
                    usersLocation.latitude,
                    usersLocation.longitude
                )
                val hourlyWeather = weatherResponse.hourly
                val dailyWeather = weatherResponse.daily

                _state.value = state.value.copy(
                    isLoading = false,
                    city = city,
                    hourlyTime = hourlyWeather.time,
                    hourly2MTemperatureList = hourlyWeather.temperature2M,
                    hourlyMaxWindSpeedList = hourlyWeather.windSpeedMax,
                    hourlyWeatherCodes = hourlyWeather.weatherCodes,
                    dailyTime = dailyWeather.time,
                    dailyMaxTemperatureList = dailyWeather.temperatureMax,
                    dailyMaxWindSpeedList = dailyWeather.windSpeedMax,
                    dailyWeatherCodes = dailyWeather.weatherCodes
                )
                Log.i("TAGY", "Weather is successfully loaded")
            } catch (e: Exception) {
                Log.i(
                    "TAGY", "Something went wrong " +
                            "while processing api call\n${e.message}"
                )
            }
        }
    }
}