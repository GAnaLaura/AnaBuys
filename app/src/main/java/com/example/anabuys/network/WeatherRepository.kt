package com.example.anabuys.network

import android.util.Log
import com.example.anabuys.core.RetrofitInstance
import com.example.anabuys.core.WeatherAPI
import com.example.anabuys.model.Weather

class WeatherRepository {
    private val retrofit = RetrofitInstance.getRetrofit().create(WeatherAPI::class.java)

    suspend fun getCurrentWeather(coordinates: String): Weather? {
        val response = retrofit.getCurrentWeather("663fbc04a6734f6996f162241251006", coordinates)
        Log.i("RESPONSE", response.body().toString())

        return response.body()
    }
}