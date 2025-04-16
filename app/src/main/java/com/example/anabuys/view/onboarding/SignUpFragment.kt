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
import com.example.anabuys.databinding.SignUpFragmentBinding
import com.example.anabuys.utils.FragmentCommunicator
import com.example.anabuys.viewModel.SignUpViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SignUpFragment : Fragment() {

    private var _binding: SignUpFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<SignUpViewModel>()
    private lateinit var communicator: FragmentCommunicator
    var isValid: Boolean = false

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


    private fun setupView(){

        binding.registerButton.setOnClickListener{

            viewModel.requestSignUp(binding.emailTIET.text.toString(),
                binding.passwordTIET.text.toString())

        }

        binding.registerButton.setOnClickListener {

            findNavController().navigate(R.id.action_SecondFragment_to_personalInformationFragment)
        }

        binding.registerButton.setOnClickListener {
            if (isValid) {
                requestRegister()
            } else {
                Toast.makeText(activity, "Ingreso invalido", Toast.LENGTH_SHORT).show()
            }
        }
        binding.emailTIET.addTextChangedListener {
            if (binding.emailTIET.text.toString().isEmpty()) {
                binding.emailTIET.error = "Por favor introduce un correo"
                isValid = false
            } else {
                isValid = true
            }
        }
        binding.passwordTIET.addTextChangedListener {
            if (binding.passwordTIET.text.toString().isEmpty()) {
                binding.passwordTIET.error = "Por favor introduce una contraseña"
                isValid = false
            } else {
                isValid = true
            }
        }


    }

    private fun setupObservers(){
        viewModel.loaderState.observe(viewLifecycleOwner) { loaderState ->
            communicator.showLoader(loaderState)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun requestRegister() {
        viewModel.requestSignUp(binding.emailTIET.text.toString(),
            binding.passwordTIET.text.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}