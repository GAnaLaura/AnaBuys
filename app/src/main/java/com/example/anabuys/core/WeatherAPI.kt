package com.example.anabuys.core

import com.example.anabuys.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String
    ): Response<Weather>

    suspend fun getWeatherInfo(
        @Query("key") apiKey: String,
        @Query("q") location: String
    ): Response<List<Weather>>
}