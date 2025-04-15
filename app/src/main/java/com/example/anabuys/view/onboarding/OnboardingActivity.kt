package com.example.anabuys.view.onboarding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.anabuys.databinding.ActivityOnboardingBinding
import com.example.anabuys.utils.FragmentCommunicator

class OnboardingActivity : AppCompatActivity(), FragmentCommunicator {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun showLoader(value: Boolean) {

        if (value) {

            binding.loaderContainerView.visibility = View.VISIBLE

        } else {

            binding.loaderContainerView.visibility = View.GONE

        }
    }

}