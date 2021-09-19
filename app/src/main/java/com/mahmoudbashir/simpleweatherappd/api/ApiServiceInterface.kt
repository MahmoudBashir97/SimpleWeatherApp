package com.mahmoudbashir.simpleweatherappd.api

import com.mahmoudbashir.simpleweatherappd.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceInterface {

    @GET("weather/cairo")
    suspend fun getWeatherCityData():Response<WeatherModel>
}