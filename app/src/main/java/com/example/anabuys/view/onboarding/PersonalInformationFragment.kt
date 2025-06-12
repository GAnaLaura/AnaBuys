package com.example.anabuys.view.onboarding

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.anabuys.R
import com.example.anabuys.databinding.PersonalInformationFragmentBinding

class PersonalInformationFragment : Fragment() {

    private var _binding : PersonalInformationFragmentBinding? = null
    private val binding get() = _binding!!

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
            try {
                findNavController().navigate(R.id.action_personalInformationFragment_to_permissionFragment)
            } catch (e: Exception) {
                showError("Ocurrió un error al continuar. Intenta de nuevo.")
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