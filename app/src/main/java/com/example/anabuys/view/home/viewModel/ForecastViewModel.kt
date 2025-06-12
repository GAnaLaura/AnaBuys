package com.example.anabuys.view.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anabuys.model.Forecast
import com.example.anabuys.network.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(

    private val repository: ForecastRepository
): ViewModel() {
    private val _forecast = MutableLiveData<List<Forecast>>()
    val forecast: LiveData<List<Forecast>> get() = _forecast
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun getForecast(location: String, days: Int = 8, lang: String = "es") {
        viewModelScope.launch {
            try {
                val response = repository.getForecast(location, days, lang)
                if (response.isSuccessful && response.body() != null) {
                    val json = response.body()!!.string()
                    _forecast.value = Forecast.parseForecast(json)
                    _error.value = null
                } else {
                    _error.value = "Error en la respuesta del servidor"
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}