package com.example.myweather.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.myweather.domain.usecases.WeatherUseCases
import com.example.myweather.presentation.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCases: WeatherUseCases
) : ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state
}