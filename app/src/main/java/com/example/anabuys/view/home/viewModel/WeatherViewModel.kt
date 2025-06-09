package com.example.anabuys.view.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anabuys.model.Weather
import com.example.anabuys.network.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepository()
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState
    private val _weatherInfo = MutableLiveData<Weather>()
    val weatherInfo: LiveData<Weather>
        get() = _weatherInfo


    fun getWeatherDetail(coordinates: String) {
        _loaderState.value = true
        viewModelScope.launch {
            try {
                val response = repository.getCurrentWeather(coordinates)
                if (response?.location?.localTime == null) {
                    throw Exception("Datos incompletos")
                }
                _weatherInfo.value = response
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")
                _weatherInfo.value = null // ← Para mostrar error en UI
            } finally {
                _loaderState.value = false
            }
        }
    }
}