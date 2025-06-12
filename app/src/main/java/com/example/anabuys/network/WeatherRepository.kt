package com.example.anabuys.network

import android.util.Log
import com.example.anabuys.core.RetrofitInstance
import com.example.anabuys.core.WeatherAPI
import com.example.anabuys.model.Weather
import javax.inject.Inject

class WeatherRepository @Inject constructor(

    private val weatherAPI: WeatherAPI

) {

    suspend fun getCurrentWeather(coordinates: String): Weather? {
        val response = weatherAPI.getCurrentWeather("663fbc04a6734f6996f162241251006", coordinates)
        Log.i("RESPONSE", response.body().toString())

        return response.body()
    }
}