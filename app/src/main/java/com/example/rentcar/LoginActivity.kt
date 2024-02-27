package com.example.rentcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.rentcar.databinding.ActivityHomeBinding
import com.example.rentcar.databinding.ActivityLoginBinding
import com.example.rentcar.databinding.ActivityMainBinding
import com.example.rentcar.databinding.ActivitySignUpBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signuptxt.setOnClickListener {
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }


            binding.loginBtn.setOnClickListener {
                if (validateEmail() && validatePassword()) {
                    // If both email and password are valid, proceed with login
                    val i = Intent(this, HomeActivity::class.java)
                    startActivity(i)
                }
            }
        }

        private fun validateEmail(): Boolean {
            val email = binding.Email.text.toString().trim()
            if (email.isEmpty()) {
                binding.Email.error = "Email is required"
                return false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.Email.error = "Enter a valid email address"
                return false
            }
            return true
        }

        private fun validatePassword(): Boolean {
            val password = binding.Password.text.toString().trim()
            if (password.isEmpty()) {
                binding.Password.error = "Password is required"
                return false
            } else if (password.length < 6) {
                binding.Password.error = "Password must be at least 6 characters"
                return false
            }
            return true
        }
    }
