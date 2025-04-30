package com.example.anabuys.core

import com.example.anabuys.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherAPI {
    @GET("/current.json")
    suspend fun getProductDetail():Response<Weather>
}