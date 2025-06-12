package com.example.anabuys.view.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.anabuys.R
import com.example.anabuys.core.LocationProvider
import com.example.anabuys.databinding.FragmentWeatherBinding
import com.example.anabuys.model.Weather
import com.example.anabuys.utils.FragmentCommunicator
import com.example.anabuys.view.home.viewModel.ForecastViewModel
import com.example.anabuys.view.home.viewModel.WeatherViewModel
import com.example.anabuys.view.home.ForecastAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val weatherViewModel by viewModels<WeatherViewModel>()
    private val forecastViewModel by viewModels<ForecastViewModel>()
    private lateinit var communicator: FragmentCommunicator

    private val forecastAdapter = ForecastAdapter()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
        val coarseGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true

        if (fineGranted || coarseGranted) {
            getUserLocation { coords ->
                weatherViewModel.getWeatherDetail(coords)
                forecastViewModel.getForecast(coords)
            }
        } else {
            Toast.makeText(requireContext(), "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        communicator = requireActivity() as FragmentCommunicator
        setupView()
        setupBottomNavigation()
        return binding.root
    }

    private fun setupView() {
        binding.rvForecast.layoutManager = LinearLayoutManager(requireContext())
        binding.rvForecast.adapter = forecastAdapter

        setupObservers()

        requestPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    private fun setupBottomNavigation() {
        val navView = binding.root.findViewById<BottomNavigationView>(R.id.navView)
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigaton_weather -> {
                    // Scroll al inicio del scrollView
                    binding.scrollView.smoothScrollTo(0, 0)
                    true
                }
                R.id.navigation_both -> {
                    // Scroll hasta antes del RecyclerView (al final del header)
                    binding.scrollView.smoothScrollTo(0, binding.rvForecast.top)
                    true
                }
                R.id.navigation_forecast -> {
                    // Scroll hasta antes del temperatureTextView
                    binding.scrollView.smoothScrollTo(0, binding.temperatureTextView.top)
                    true
                }
                else -> false
            }
        }
        navView.selectedItemId = R.id.navigaton_weather
    }

    private fun getUserLocation(onLocationReady: (String) -> Unit) {
        val hasFine = ContextCompat.checkSelfPermission(
            requireContext(), Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val hasCoarse = ContextCompat.checkSelfPermission(
            requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (hasFine || hasCoarse) {
            lifecycleScope.launch {
                val location = LocationProvider.getInstance(requireContext())
                    .getCurrentLocation()
                if (location != null) {
                    val coords = "${location.latitude},${location.longitude}"
                    Log.i("LOCATION", "Location: $coords")
                    onLocationReady(coords)
                } else {
                    Log.e("LOCATION", "Error al obtener ubicación")
                }
            }
        }
    }

    private fun setupObservers() {
        weatherViewModel.weatherInfo.observe(viewLifecycleOwner) { weather ->
            showWeatherInfo(weather)
        }
        weatherViewModel.loaderState.observe(viewLifecycleOwner) { state ->
            communicator.showLoader(state)
        }

        forecastViewModel.forecast.observe(viewLifecycleOwner) { list ->
            forecastAdapter.submitList(list)
        }
        forecastViewModel.error.observe(viewLifecycleOwner) { msg ->
            msg?.let { Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show() }
        }
    }

    private fun showWeatherInfo(weather: Weather) {
        binding.locationTextView.text = weather.location.name
        binding.dateTimeTextView.text = weather.location.localTime
        binding.temperatureTextView.text = weather.current.tempC.toString()
        binding.windSpeedTextView.text = weather.current.windKph.toString()
        binding.greetingTextView.text =
            if (weather.current.isDay == 1) "Good morning" else "Good night"

        Glide.with(this)
            .load("https:${weather.current.condition.icon}")
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.weatherIconImageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}