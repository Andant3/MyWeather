package com.example.myweather.di

import com.example.myweather.data.repository.RepositoryImpl
import com.example.myweather.domain.repository.Repository
import com.example.myweather.domain.usecases.GetWeatherFromApi
import com.example.myweather.domain.usecases.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {

    @Provides
    @Singleton
    fun providesWeatherRepository(): Repository {
        return RepositoryImpl()
    }
    
    @Provides
    @Singleton
    fun provideWeatherUseCases(repository: Repository): WeatherUseCases{
        return WeatherUseCases(
            getWeatherFromApi = GetWeatherFromApi(repository)
        )
    }
}