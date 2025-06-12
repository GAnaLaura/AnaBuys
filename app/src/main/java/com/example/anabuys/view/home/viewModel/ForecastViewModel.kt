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
            val result = repository.getForecast(location, days, lang)
            result.fold(
                onSuccess = { responseBody ->
                    val json = responseBody.string()
                    _forecast.value = Forecast.parseForecast(json)
                    _error.value = null
                },
                onFailure = { exception ->
                    _error.value = exception.message ?: "Error desconocido"
                }
            )
        }
    }
}