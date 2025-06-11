package com.example.anabuys.network

import com.example.anabuys.core.ForecastAPI
import com.example.anabuys.core.RetrofitInstance
import okhttp3.ResponseBody
import retrofit2.Response

class ForecastRepository {
    private val forecastApi = RetrofitInstance.getRetrofit().create(ForecastAPI::class.java)
    private val apiKey = "663fbc04a6734f6996f162241251006" // tu API key

    suspend fun getForecast(
        location: String,
        days: Int,
        lang: String
    ): Response<ResponseBody> {
        return forecastApi.getForecast(apiKey, location, days, lang)
    }
}