package com.example.anabuys.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.anabuys.R
import com.example.anabuys.network.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import com.bumptech.glide.Glide
import android.widget.ImageView


class WeatherFragment : Fragment() {

    private val weatherRepository = WeatherRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        fetchWeatherData(view)

        return view
    }

    private fun fetchWeatherData(view: View) {
        val apiKey = "ddc99a020f204b9dbc252459253004"
        val location = "Karachi" // Cambia por la ubicación deseada

        lifecycleScope.launch {
            val weather = withContext(Dispatchers.IO) {
                weatherRepository.getCurrentWeather(apiKey, location)
            }

            weather?.let {

                // Actualizar la UI con los datos obtenidos

                val locationTextView = view.findViewById<TextView>(R.id.locationTextView)
                val temperatureTextView = view.findViewById<TextView>(R.id.temperatureTextView)
                val windSpeedTextView = view.findViewById<TextView>(R.id.windSpeedTextView)
                val sunsetTimeTextView = view.findViewById<TextView>(R.id.sunsetTimeTextView)
                val dateTimeTextView = view.findViewById<TextView>(R.id.dateTimeTextView)

                val weatherIconImageView = view.findViewById<ImageView>(R.id.weatherIconImageView)

                locationTextView.text = it.location.name
                temperatureTextView.text = "${it.current.temp_c}°C"
                windSpeedTextView.text = "${it.current.wind_kph / 3.6} m/s" // Convertir de km/h a m/s
                sunsetTimeTextView.text = it.current.sunset ?: "N/A"
                dateTimeTextView.text = it.location.localtime


                // Cargar el ícono del clima usando Glide

                Glide.with(this@WeatherFragment)
                    .load("https:${it.current.condition.icon}")
                    .into(weatherIconImageView)

            }


        }
    }
}

