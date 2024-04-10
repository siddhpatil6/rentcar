package com.example.rentcar.ui.activity

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.rentcar.R
import com.example.rentcar.ui.fragment.HomeFragment
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

        onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
            // For example, show a dialog
            val currentFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            if (currentFragment is  NavHostFragment) {
                (currentFragment as HomeFragment).onBackPressed()
            }else{
                fragmentManager.popBackStack()
            }

        }


    }
    override fun onBackPressed() {
        // Add your custom back press logic here
        // For example, you can show a dialog or perform some action
        super.onBackPressed()

    }

}
