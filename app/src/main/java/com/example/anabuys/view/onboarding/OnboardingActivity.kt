package com.example.anabuys.view.onboarding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anabuys.databinding.ActivityOnboardingBinding
import com.example.anabuys.utils.FragmentCommunicator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity(), FragmentCommunicator {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityOnboardingBinding.inflate(layoutInflater)
            setContentView(binding.root)
        } catch (e: Exception) {
            showError("Ocurrió un error al iniciar la pantalla de bienvenida.")
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