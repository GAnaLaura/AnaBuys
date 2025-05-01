package com.example.anabuys.model

data class Weather(
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val localtime: String
)

data class Current(
    val temp_c: Double,
    val condition: Condition,
    val wind_kph: Double,
    val sunset: String? = null
)

data class Condition(
    val text: String,
    val icon: String
)