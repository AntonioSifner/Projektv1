package com.example.projektv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import java.util.Locale

class Login : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val loginButton: Button = findViewById(R.id.loginButton)
        val registerButton: Button = findViewById(R.id.registerButton)

        loginButton.setOnClickListener{
            val email = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()
            loginUser(email, password)
        }

        registerButton.setOnClickListener{
            val email = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()
            registerUser(email, password)
        }

        val actionBar = supportActionBar
        actionBar!!.title = "Login"
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.let {
                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(email.substringBefore("@")) // Set display name to the part before '@'
                            .build()

                        it.updateProfile(profileUpdates)
                            .addOnCompleteListener { updateTask ->
                                if (updateTask.isSuccessful) {
                                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                    }
                } else {
                    val errorMessage = task.exception?.message ?: "Authentification failed."
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.let {
                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(email.substringBefore("@")) // Set display name to the part before '@'
                            .build()

                        it.updateProfile(profileUpdates)
                            .addOnCompleteListener { updateTask ->
                                if (updateTask.isSuccessful) {
                                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                    }
                } else {
                    val errorMessage = task.exception?.message ?: "Registration failed."
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
    }
}