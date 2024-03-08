package com.example.rentcar.ui.activity


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rentcar.R
import com.example.rentcar.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        binding.logintxt.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        val registerBtn: Button = findViewById(R.id.RegisterBtn)
        registerBtn.setOnClickListener {
            val fullName = binding.Fullname.text.toString().trim()
            val email = binding.Email.text.toString().trim()
            val password = binding.Password.text.toString().trim()
            val phone = binding.Phone.text.toString().trim()

            if (validateFullName(fullName) && validateEmail(email) && validatePassword(password) && validatePhone(phone)) {
                // Proceed with the registration process
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Registration success, save additional user data in Firebase Realtime Database
                            val userId = auth.currentUser?.uid
                            val userRef = database.getReference("users").child(userId!!)
                            userRef.child("fullName").setValue(fullName)
                            userRef.child("email").setValue(email)
                            userRef.child("phone").setValue(phone)

                            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

                            // After successful registration, navigate to the login page
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // Registration failed
                            Toast.makeText(baseContext, "Registration failed. Please try again later.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    private fun validateFullName(fullName: String): Boolean {
        if (fullName.isEmpty()) {
            binding.Fullname.error = "Full name is required"
            return false
        }
        return true
    }

    private fun validateEmail(email: String): Boolean {
        if (email.isEmpty()) {
            binding.Email.error = "Email is required"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.Email.error = "Enter a valid email address"
            return false
        }
        return true
    }

    private fun validatePassword(password: String): Boolean {
        if (password.isEmpty()) {
            binding.Password.error = "Password is required"
            return false
        } else if (password.length < 6) {
            binding.Password.error = "Password must be at least 6 characters"
            return false
        }
        return true
    }

    private fun validatePhone(phone: String): Boolean {
        if (phone.isEmpty()) {
            binding.Phone.error = "Phone number is required"
            return false
        } else if (!phone.matches(Regex("\\d{10}"))) {
            binding.Phone.error = "Phone number must be 10 digits long"
            return false
        }
        return true
    }
}
