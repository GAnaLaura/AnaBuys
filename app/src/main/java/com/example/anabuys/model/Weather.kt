package com.example.anabuys.model

import com.google.gson.annotations.SerializedName

data class Weather(
    val location: Location,
    val current: Current
) {

    data class Location(

        val name: String,
        val region: String,
        val country: String,
        val lat: Double,
        val lon: Double,
        @SerializedName("localtime") val localTime: String,
        @SerializedName("tz_id") val timezone: String
    )

    data class Current(
        @SerializedName("temp_c") val tempC: Double,
        @SerializedName("is_day") val isDay: Int,
        val condition: Condition,
        @SerializedName("wind_kph") val windKph: Double,
        @SerializedName("humidity") val humidity: Int,
        @SerializedName("feelslike_c") val feelsLikeC: Double
    )

    data class Condition(
        val text: String,
        val icon: String,
        val code: Int
    )

}