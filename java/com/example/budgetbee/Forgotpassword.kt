package com.example.budgetbee

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPassword : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        emailInput = findViewById(R.id.et_email_reset)
        resetButton = findViewById(R.id.btn_reset_password)

        resetButton.setOnClickListener {
            val email = emailInput.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            } else {
                // This is a placeholder; actual reset logic would go here.
                Toast.makeText(this, "Password reset link sent to $email", Toast.LENGTH_LONG).show()
                finish() // Go back to previous screen
            }
        }
    }
}
