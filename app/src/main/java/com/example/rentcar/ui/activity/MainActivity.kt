package com.example.rentcar.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentcar.IntroViewPagerAdapter
import com.example.rentcar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val introViewPagerAdapter = IntroViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = introViewPagerAdapter
    }
}