package com.example.anabuys.network

import android.util.Log
import com.example.anabuys.core.RetrofitInstance
import com.example.anabuys.core.WeatherAPI
import com.example.anabuys.model.Weather

class WeatherRepository {
    private val retrofit = RetrofitInstance.getRetrofit().create(WeatherAPI::class.java)

    suspend fun getCurrentWeather(apiKey: String, location: String): Weather? {
        return try {
            val response = retrofit.getCurrentWeather(apiKey, location)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("WeatherRepository", "Error: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("WeatherRepository", "Exception: ${e.message}")
            null
        }
    }
}