package com.example.rentcar.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.rentcar.R
import com.example.rentcar.custom.PreferenceManager
import com.example.rentcar.databinding.ActivityLoginBinding
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.home.CarListViewModelFactory
import com.example.rentcar.ui.models.LoginDetailModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val carListViewModel: CarListViewModel by viewModels { CarListViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var prefManager = PreferenceManager(applicationContext)

        binding.signuptxt.setOnClickListener {
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }

        carListViewModel.loginResponseLiveData.observe(this, Observer { loginResponseModel ->
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            prefManager.isLoggedIn = true
            prefManager.saveProfile(loginResponseModel)

        })

        binding.loginBtn.setOnClickListener {
                if (validateEmail() && validatePassword()) {
                    carListViewModel.getLogin(LoginDetailModel(email = binding.Email.text.toString(), password = binding.Password.text.toString()))
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
