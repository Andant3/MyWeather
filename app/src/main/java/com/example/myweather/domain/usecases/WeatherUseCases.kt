package com.example.myweather.domain.usecases

data class WeatherUseCases(
    val getWeatherFromApi: GetWeatherFromApi,
    val getUsersLocation: GetUsersLocation,
    val getCityByLocation: GetCityByLocation
) {
}