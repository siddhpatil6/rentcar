package com.example.rentcar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rentcar.databinding.ActivitySlider01Binding
import com.example.rentcar.databinding.ActivitySlider04Binding

class SliderThreeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_slider04, container, false)

        val skipBtn = rootView.findViewById<View>(R.id.skipbtn4)
        skipBtn.setOnClickListener {
            // Handle the click event (add your intent logic here)
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }
}
