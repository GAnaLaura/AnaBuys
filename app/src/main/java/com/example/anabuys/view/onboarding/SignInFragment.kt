package com.example.anabuys.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.anabuys.R
import com.example.anabuys.databinding.SignInFragmentBinding
import com.example.anabuys.utils.FragmentCommunicator
import com.example.anabuys.viewModel.SignInViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SignInFragment : Fragment() {

    private var _binding: SignInFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<SignInViewModel>()
    var isValid: Boolean = false

    private lateinit var communicator: FragmentCommunicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SignInFragmentBinding.inflate(inflater, container, false)
        communicator = requireActivity() as OnboardingActivity
        setupView()
        return binding.root

    }

    private fun setupView() {
        binding.registerTextView.setOnClickListener {

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.loginButton.setOnClickListener {
            if (isValid) {
                requestLogin()
            } else {
                Toast.makeText(activity, "Ingreso invalido", Toast.LENGTH_SHORT).show()
            }
        }
        binding.editTextEmailAddress.addTextChangedListener {
            if (binding.editTextEmailAddress.text.toString().isEmpty()) {
                binding.editTextEmailAddress.error = "Por favor introduce un correo"
                isValid = false
            } else {
                isValid = true
            }
        }
        binding.editTextPassword.addTextChangedListener {
            if (binding.editTextPassword.text.toString().isEmpty()) {
                binding.editTextPassword.error = "Por favor introduce una contraseña"
                isValid = false
            } else {
                isValid = true
            }
        }
    }

    private fun requestLogin() {
        viewModel.requestSignIn(binding.editTextEmailAddress.text.toString(),
            binding.editTextPassword.text.toString())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}