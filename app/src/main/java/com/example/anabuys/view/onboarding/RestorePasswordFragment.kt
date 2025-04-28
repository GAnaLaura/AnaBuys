package com.example.anabuys.view.onboarding

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.anabuys.viewModel.BlankViewModel
import com.example.anabuys.R
import com.example.anabuys.databinding.RestorePasswordFragmentBinding
import com.example.anabuys.utils.FragmentCommunicator


class RestorePasswordFragment : Fragment() {

    private var _binding : RestorePasswordFragmentBinding? = null
    private val  binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RestorePasswordFragmentBinding.inflate(inflater, container, false)
        setupView()
        return binding.root

    }

    private fun setupView(){
        binding.restoreBack.setOnClickListener{
            findNavController().navigate(R.id.action_restorePasswordFragment_to_FirstFragment)
        }
    }

}