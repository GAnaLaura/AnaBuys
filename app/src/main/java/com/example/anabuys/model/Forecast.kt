package com.example.anabuys.model

import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * Modelo simplificado del pronóstico para la UI:
 * - dia: nombre del día en inglés (minúscula)
 * - icono: URL relativa al icono
 * - temperaturaMax / temperaturaMin: en °C
 *
 * El manejo de errores de parsing debe hacerse en el repositorio o ViewModel.
 */
data class Forecast(
    val dia: String,
    val icono: String,
    val temperaturaMax: Double,
    val temperaturaMin: Double
) {
    companion object {
        fun parseForecast(json: String): List<Forecast> {
            val result = mutableListOf<Forecast>()
            try {
                val root = JSONObject(json)
                val forecastArray = root
                    .getJSONObject("forecast")
                    .getJSONArray("forecastday")

                // Formato de fecha para parsear "YYYY-MM-DD"
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)

                for (i in 0 until forecastArray.length()) {
                    val dayObj = forecastArray.getJSONObject(i)
                    val dateStr = dayObj.getString("date")
                    val date = sdf.parse(dateStr)!!  // java.util.Date

                    // Extraer día de la semana en inglés
                    val cal = Calendar.getInstance().apply { time = date }
                    val diaSemana = cal.getDisplayName(
                        Calendar.DAY_OF_WEEK,
                        Calendar.LONG,
                        Locale.ENGLISH
                    )!!.lowercase()

                    val dayInfo = dayObj.getJSONObject("day")
                    val condition = dayInfo.getJSONObject("condition")

                    val icono   = condition.getString("icon")
                    val tempMax = dayInfo.getDouble("maxtemp_c")
                    val tempMin = dayInfo.getDouble("mintemp_c")

                    result += Forecast(diaSemana, icono, tempMax, tempMin)
                }
            } catch (e: Exception) {
                // Si ocurre un error de parsing, puedes lanzar una excepción o retornar una lista vacía
                // Aquí retornamos una lista vacía y puedes manejar el error en el ViewModel o UI
                return emptyList()
            }
            return result
        }
    }
}