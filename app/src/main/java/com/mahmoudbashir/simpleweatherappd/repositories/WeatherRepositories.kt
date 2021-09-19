package com.mahmoudbashir.simpleweatherappd.repositories

import com.mahmoudbashir.simpleweatherappd.api.ApiServiceInterface
import javax.inject.Inject

class WeatherRepositories
@Inject constructor(private val apiService:ApiServiceInterface
){
    suspend fun getWeather() = apiService.getWeatherCityData()

}