package com.example.anabuys.view.onboarding

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.anabuys.R
import com.example.anabuys.databinding.PersonalInformationFragmentBinding

class PersonalInformationFragment : Fragment() {

    private var _binding : PersonalInformationFragmentBinding? = null
    private val binding get() = _binding!!
    var isValid: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PersonalInformationFragmentBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {

        binding.btnContinuar.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val apellidos = binding.etApellidos.text.toString().trim()
            val nombreUsuario = binding.etNombreUsuario.text.toString().trim()
            val fechaNacimiento = binding.etFechaNacimiento.text.toString().trim()

            var isValid = true

            if (nombre.isEmpty()) {
                binding.tilNombre.error = "Por favor introduce tu nombre"
                isValid = false
            } else {
                binding.tilNombre.error = null
            }

            if (apellidos.isEmpty()) {
                binding.tilApellidos.error = "Por favor introduce tus apellidos"
                isValid = false
            } else {
                binding.tilApellidos.error = null
            }

            if (nombreUsuario.isEmpty()) {
                binding.etNombreUsuario.error = "Por favor introduce tu nombre de usuario"
                isValid = false
            } else {
                binding.etNombreUsuario.error = null
            }

            if (fechaNacimiento.isEmpty()) {
                binding.etFechaNacimiento.error = "Por favor introduce tu fecha de nacimiento"
                isValid = false
            } else {
                binding.etFechaNacimiento.error = null
            }

            if (isValid) {
                findNavController().navigate(R.id.action_personalInformationFragment_to_permissionFragment)
            } else {
                Toast.makeText(requireContext(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}