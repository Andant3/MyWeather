package com.example.myweather.presentation.events

sealed class WeatherEvent {
    data class DayChanged(val day: Int) : WeatherEvent()
    data object Refresh: WeatherEvent()
}