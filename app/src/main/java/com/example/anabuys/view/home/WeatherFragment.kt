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
import android.Manifest
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import com.example.anabuys.core.LocationProvider
import androidx.activity.result.contract.ActivityResultContracts
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.anabuys.databinding.FragmentWeatherBinding
import com.example.anabuys.model.Weather
import com.example.anabuys.utils.FragmentCommunicator
import com.example.anabuys.view.home.viewModel.WeatherViewModel


class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null

    private val binding get() = _binding!!
    private val viewModel by viewModels<WeatherViewModel>()
    private lateinit var communicator: FragmentCommunicator

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineLocationGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
        val coarseLocationGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true

        if (fineLocationGranted || coarseLocationGranted) {
            // Permiso concedido
            getUserLocation { coordinates -> viewModel.getWeatherDetail(coordinates)  // usamos ubicación real para pedir el clima
            }
        } else {
            // Permiso negado
            Toast.makeText(requireContext(), "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        communicator = requireActivity() as HomeActivity
        setupView()
        return binding.root
    }

    fun setupView() {

        requestPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        setupObservers()
        //val coordinates = getUserLocation()
        //viewModel.getWeatherDetail(coordinates)
    }


    fun getUserLocation(onLocationReady: (String) -> Unit) {
        if (ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            lifecycleScope.launch {
                val location = LocationProvider.getInstance(requireContext()).getCurrentLocation()
                location?.let {
                    val coordinates = "${it.latitude},${it.longitude}"  // Conversión de coordenadas a String
                    Log.i("LOCATION", "Location: $coordinates")
                    onLocationReady(coordinates)
                } ?: run {
                    Log.e("LOCATION", "ALGO SALIÓ MAL CON LA LOCACIÓN")
                }
            }
        }
    }


    fun setupObservers() {

        viewModel.weatherInfo.observe(viewLifecycleOwner) { weather ->
            showWeatherInfo(weather)
        }

        viewModel.loaderState.observe(viewLifecycleOwner) { loaderState ->
           communicator.showLoader(loaderState)
        }
    }

    fun showWeatherInfo(weather: Weather) {
        binding.locationTextView.text = weather.location.name
        binding.temperatureTextView.text = weather.current.tempC.toString()
        binding.windSpeedTextView.text = weather.current.windKph.toString()
        binding.greetingTextView.text = if (weather.current.isDay == 1) "Good morning" else "Good night"
        binding.dateTimeTextView.text = weather.location.localTime


        Glide.with(this)
            .load("https:${weather.current.condition.icon}")
            .error(R.drawable.ic_launcher_foreground) // ← Imagen de fallback
            .into(binding.weatherIconImageView)
    }
    /*
    fun getUserCoordinates(): String {
        return "19.32871829633027, -99.16549389549148"
    }
    */

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

