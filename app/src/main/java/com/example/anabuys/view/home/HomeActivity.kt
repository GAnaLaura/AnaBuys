package com.example.anabuys.view.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anabuys.R
import com.example.anabuys.databinding.ActivityHomeBinding
import com.example.anabuys.utils.FragmentCommunicator
import com.example.anabuys.view.home.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), FragmentCommunicator {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)
            Log.d("HomeActivity", "Entrando a HomeActivity")
            Log.d("HomeActivity", "Seteado binding con éxito")

            // Mostrar el WeatherFragment solo la primera vez
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, WeatherFragment())
                    .commit()
            }
        } catch (e: Exception) {
            Log.e("HomeActivity", "Error al crear la actividad", e)
            showError("Ocurrió un error al iniciar la pantalla principal.")
        }
    }

    override fun showLoader(value: Boolean) {
        binding.loaderContainerView.visibility = if (value) View.VISIBLE else View.GONE
    }

    /**
     * Muestra un mensaje de error al usuario usando un Toast.
     * Puedes cambiar esto por un Snackbar o una vista personalizada si lo prefieres.
     */
    fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}