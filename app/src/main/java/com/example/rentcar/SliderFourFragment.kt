package com.example.rentcar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rentcar.databinding.ActivitySlider05Binding

class SliderFourFragment : Fragment() {
    private lateinit var binding: ActivitySlider05Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivitySlider05Binding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener {
            val myIntent = Intent(activity, SignUpActivity::class.java)
            requireActivity().startActivity(myIntent)
        }
        return binding.root
    }
}