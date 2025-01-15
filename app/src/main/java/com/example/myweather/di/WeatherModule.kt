package com.example.myweather.di

import android.content.Context
import com.example.myweather.data.repository.WeatherRepositoryImpl
import com.example.myweather.domain.repository.WeatherRepository
import com.example.myweather.domain.usecases.GetUsersLocation
import com.example.myweather.domain.usecases.GetWeatherFromApi
import com.example.myweather.domain.usecases.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(@ApplicationContext context: Context): WeatherRepository {
        return WeatherRepositoryImpl(context)
    }
    
    @Provides
    @Singleton
    fun provideWeatherUseCases(repository: WeatherRepository): WeatherUseCases{
        return WeatherUseCases(
            getWeatherFromApi = GetWeatherFromApi(repository),
            getUsersLocation = GetUsersLocation(repository)
        )
    }
}