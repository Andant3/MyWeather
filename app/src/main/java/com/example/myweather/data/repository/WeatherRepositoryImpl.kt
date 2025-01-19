package com.example.myweather.data.repository

import android.Manifest.permission
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myweather.data.retrofit.RetrofitInstance
import com.example.myweather.data.retrofit.WeatherService
import com.example.myweather.domain.model.UserLocation
import com.example.myweather.domain.model.Weather
import com.example.myweather.domain.repository.WeatherRepository
import com.google.android.gms.location.LocationServices
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class WeatherRepositoryImpl(private val context: Context) : WeatherRepository {

    override suspend fun getWeatherDataFromApi(lat: Double, long: Double): Weather {
        return RetrofitInstance.api.getWeatherFromApi(
            latitude = lat,
            longitude = long,
            weather_code_daily = WeatherService.WEATHER_CODE_PARAMETER,
            temperature_2m = WeatherService.TEMPERATURE_2M_PARAMETER,
            wind_speed = WeatherService.WIND_SPEED_PARAMETER,
            weather_code_hourly = WeatherService.WEATHER_CODE_PARAMETER,
            temperature_2m_min = WeatherService.TEMPERATURE_2M_PARAMETER_MIN,
            temperature_2m_max = WeatherService.TEMPERATURE_2M_PARAMETER_MAX,
            wind_speed_max = WeatherService.WIND_SPEED_PARAMETER_MAX
        )
    }

    override suspend fun getUsersLocation(): UserLocation {

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        var userLocation = UserLocation(0.1, 0.1)

        if ((ContextCompat.checkSelfPermission(
                context,
                permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
                    ) || (ContextCompat.checkSelfPermission(
                context,
                permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED)
        ) {
            suspendCoroutine<Location> { coroutine ->
                fusedLocationClient.lastLocation
                    .addOnCompleteListener { locationTask ->

                        userLocation = UserLocation(
                            locationTask.result.latitude,
                            locationTask.result.longitude
                        )

                        Log.i("TAGY", "Location Loaded")
                        coroutine.resume(locationTask.result)
                    }
            }


        } else {
            userLocation = UserLocation(0.0, 0.0)
            Toast.makeText(
                context,
                "GPS permission denied, change it in your Settings",
                Toast.LENGTH_SHORT
            ).show()
        }

        return userLocation
    }

    override suspend fun getCityByLocation(lat: Double, long: Double): String {

        lateinit var cityName: String
        val geoCoder = Geocoder(context, Locale.getDefault())
        suspendCoroutine<MutableList<Address>> { coroutine ->
            geoCoder.getFromLocation(
                lat, long, 1
            ) { address ->
                cityName = address[0].locality
                Log.i(
                    "TAGY", "City parsed from lat and long " +
                            "\n${cityName}"
                )
                coroutine.resume(address)
            }
        }
        return cityName
    }
}