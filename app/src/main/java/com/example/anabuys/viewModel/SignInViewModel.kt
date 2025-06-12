package com.example.anabuys.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class SignInViewModel: ViewModel() {
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState
    private val _sessionValid = MutableLiveData<Boolean>()
    val sessionValid: LiveData<Boolean>
        get() = _sessionValid
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error
    private val firebase = FirebaseAuth.getInstance()

    fun requestSignIn(email: String, password: String) {
        _loaderState.value = true

        viewModelScope.launch {
            try {
                val result = firebase.signInWithEmailAndPassword(email, password).await()
                _loaderState.value = false
                result.user?.let {
                    _sessionValid.value = true
                    _error.value = null
                } ?: run {
                    Log.i("Firebase", "Ocurrió un problema")
                    _sessionValid.value = false
                    _error.value = "No se pudo iniciar sesión"
                }
            } catch (e: Exception) {
                Log.e("Firebase", "Error al iniciar sesión", e)
                _loaderState.value = false
                _sessionValid.value = false
                _error.value = e.message ?: "Error desconocido"
            }
        }
    }
}