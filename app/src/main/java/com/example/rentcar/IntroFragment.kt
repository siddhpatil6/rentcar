package com.example.rentcar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class IntroFragment : Fragment() {
 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
 inflater.inflate(R.layout.fragment_intro, container, false)!!
}