package com.example.anabuys.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.anabuys.R
import com.example.anabuys.databinding.SignUpFragmentBinding
import com.example.anabuys.utils.FragmentCommunicator
import com.example.anabuys.viewModel.SignUpViewModel

class SignUpFragment : Fragment() {

    private var _binding: SignUpFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SignUpViewModel>()
    private lateinit var communicator: FragmentCommunicator
    private var isValid: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false)
        communicator = requireActivity() as OnboardingActivity
        setupView()
        setupObservers()
        return binding.root
    }

    private fun setupView() {

        binding.registerButton.setOnClickListener {
            if (isValid) {
                requestRegister()
            } else {
                Toast.makeText(activity, "Ingreso invalido", Toast.LENGTH_SHORT).show()
            }
        }

        binding.emailTIET.addTextChangedListener {
            binding.emailTIET.error = if (it.isNullOrEmpty()) {
                isValid = false
                "Por favor introduce un correo"
            } else {
                isValid = true
                null
            }
        }

        binding.passwordTIET.addTextChangedListener {
            binding.passwordTIET.error = if (it.isNullOrEmpty()) {
                isValid = false
                "Por favor introduce una contraseña"
            } else {
                isValid = true
                null
            }
        }
    }

    private fun setupObservers() {
        viewModel.loaderState.observe(viewLifecycleOwner) { loaderState ->
            communicator.showLoader(loaderState)
        }

        viewModel.signUpSuccess.observe(viewLifecycleOwner) { success ->
            if (success) {
                findNavController().navigate(R.id.action_SecondFragment_to_personalInformationFragment)
            }
        }
    }

    private fun requestRegister() {
        viewModel.requestSignUp(
            binding.emailTIET.text.toString(),
            binding.passwordTIET.text.toString()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
