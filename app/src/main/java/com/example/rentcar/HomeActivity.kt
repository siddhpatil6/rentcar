package com.example.rentcar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // Find reference to bottom navigation view
        val navController = navHostFragment.navController

        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        // Hook your navigation controller to bottom navigation view
        navView.setupWithNavController(navController)

    }

}
