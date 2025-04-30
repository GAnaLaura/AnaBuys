package com.example.anabuys.core

import com.example.anabuys.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("/v1/current.json") // Endpoint para obtener el clima actual
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String, // Clave de API
        @Query("q") location: String // Ubicación (ejemplo: "London")
    ): Response<Weather>
}