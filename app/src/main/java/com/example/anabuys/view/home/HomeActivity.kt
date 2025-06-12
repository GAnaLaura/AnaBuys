package com.example.anabuys.view.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.anabuys.R
import com.example.anabuys.databinding.ActivityHomeBinding
import com.example.anabuys.utils.FragmentCommunicator
import com.example.anabuys.view.home.WeatherFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
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
        }

        val navView : BottomNavigationView = binding.navView
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHost.navController
        navView.setupWithNavController(navController)
        setContentView(binding.root)
    }

    override fun showLoader(value: Boolean) {

        binding.loaderContainerView.visibility = if (value) View.VISIBLE else View.GONE
    }
}