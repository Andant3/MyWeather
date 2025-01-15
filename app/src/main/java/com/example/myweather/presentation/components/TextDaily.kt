package com.example.myweather.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myweather.presentation.viewmodel.WeatherViewModel

@Composable
fun TextDaily(viewModel: WeatherViewModel = hiltViewModel()) {

    val weatherState = viewModel.state.value
    Text(
        text = weatherState.dailyTime[0]
    )
}