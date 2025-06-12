package com.example.anabuys.network

import android.util.Log
import com.example.anabuys.core.WeatherAPI
import com.example.anabuys.model.Weather
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherAPI: WeatherAPI
) {

    suspend fun getCurrentWeather(coordinates: String): Result<Weather> {
        return try {
            val response = weatherAPI.getCurrentWeather("663fbc04a6734f6996f162241251006", coordinates)
            if (response.isSuccessful) {
                val weather = response.body()
                if (weather != null) {
                    Result.success(weather)
                } else {
                    Result.failure(Exception("Respuesta vacía del servidor"))
                }
            } else {
                Result.failure(Exception("Error del servidor: ${response.code()} ${response.message()}"))
            }
        } catch (e: IOException) {
            Log.e("WeatherRepository", "Error de red", e)
            Result.failure(Exception("No se pudo conectar al servidor. Verifica tu conexión a internet."))
        } catch (e: HttpException) {
            Log.e("WeatherRepository", "Error HTTP", e)
            Result.failure(Exception("Error HTTP: ${e.code()}"))
        } catch (e: Exception) {
            Log.e("WeatherRepository", "Error desconocido", e)
            Result.failure(Exception("Ocurrió un error inesperado"))
        }
    }
}