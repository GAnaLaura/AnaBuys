package com.example.anabuys.network

import android.util.Log
import com.example.anabuys.core.RetrofitInstance
import com.example.anabuys.core.WeatherAPI
import com.example.anabuys.model.Weather

class WeatherRepository {
    private val  retrofit = RetrofitInstance.getRetrofit().create(WeatherAPI::class.java)

    suspend fun getProductDetail(): Weather? {
        val response = retrofit.getProductDetail()
        Log.i("RESPONSE", response.body().toString())

        return response.body()
    }
}