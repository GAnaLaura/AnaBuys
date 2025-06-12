package com.example.anabuys.network

import com.example.anabuys.core.ForecastAPI
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class ForecastRepository @Inject constructor(
    private val forecastAPI: ForecastAPI
) {
    private val apiKey = "663fbc04a6734f6996f162241251006" // tu API key

    suspend fun getForecast(
        location: String,
        days: Int,
        lang: String
    ): Result<ResponseBody> {
        return try {
            val response = forecastAPI.getForecast(apiKey, location, days, lang)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    Result.success(body)
                } else {
                    Result.failure(Exception("Respuesta vacía del servidor"))
                }
            } else {
                Result.failure(Exception("Error del servidor: ${response.code()} ${response.message()}"))
            }
        } catch (e: IOException) {
            Result.failure(Exception("No se pudo conectar al servidor. Verifica tu conexión a internet."))
        } catch (e: HttpException) {
            Result.failure(Exception("Error HTTP: ${e.code()}"))
        } catch (e: Exception) {
            Result.failure(Exception("Ocurrió un error inesperado"))
        }
    }
}