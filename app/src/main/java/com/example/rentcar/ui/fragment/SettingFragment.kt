package com.example.rentcar.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rentcar.custom.PreferenceManager
import com.example.rentcar.databinding.FragmentSettingBinding
import com.example.rentcar.ui.activity.HomeActivity
import com.example.rentcar.ui.activity.LoginActivity


class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefManager = context?.applicationContext?.let { PreferenceManager(it) }

        binding.rlLogout.setOnClickListener {
            prefManager?.clearProfile()
            prefManager?.isLoggedIn = false
            callLoginActivity()
        }

        binding.rlExit.setOnClickListener {
            callExitApp()
        }
    }

    fun callLoginActivity(){
        val intent = Intent(context, LoginActivity::class.java)
        activity?.startActivity(intent)
        activity?.finish()
    }

    fun callExitApp(){
        activity?.finishAffinity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }
}