package com.example.anabuys.view.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anabuys.model.Weather
import com.example.anabuys.network.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState
    private val _weatherInfo = MutableLiveData<Weather?>()
    val weatherInfo: LiveData<Weather?>
        get() = _weatherInfo
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun getWeatherDetail(coordinates: String) {
        _loaderState.value = true
        viewModelScope.launch {
            val result = repository.getCurrentWeather(coordinates)
            result.fold(
                onSuccess = { weather ->
                    if (weather.location?.localTime == null) {
                        _error.value = "Datos incompletos"
                        _weatherInfo.value = null
                    } else {
                        _weatherInfo.value = weather
                        _error.value = null
                    }
                },
                onFailure = { exception ->
                    Log.e("API", "Error: ${exception.message}")
                    _error.value = exception.message ?: "Error desconocido"
                    _weatherInfo.value = null
                }
            )
            _loaderState.value = false
        }
    }
}