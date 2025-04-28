package com.example.anabuys.view.onboarding

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.anabuys.viewModel.BlankViewModel3
import com.example.anabuys.R
import com.example.anabuys.databinding.PermissionFragmentBinding


class PermissionFragment : Fragment() {

    private var _binding : PermissionFragmentBinding? = null
    private val  binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PermissionFragmentBinding.inflate(inflater, container, false)
        setupView()
        return binding.root

    }

    private fun setupView(){
        binding.button2.setOnClickListener{
            findNavController().navigate(R.id.action_permissionFragment_to_FirstFragment)
        }
    }

}