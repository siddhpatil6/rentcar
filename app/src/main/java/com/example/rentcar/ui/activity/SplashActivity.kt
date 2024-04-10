package com.example.rentcar.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.rentcar.R
import com.example.rentcar.custom.PreferenceManager


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val prefManager = PreferenceManager(applicationContext)

        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            // Start your app main activity
            if (prefManager.isLoggedIn){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }

        }, 3000)
    }
}