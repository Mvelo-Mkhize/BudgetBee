package com.example.budgetbee

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FAQ : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)

        val ForgotPasswordButton = findViewById<ImageButton>(R.id.home_button)
        val GlobalAvailabilityButton = findViewById<ImageButton>(R.id.history_button)
        val SupportedCurrenciesButton = findViewById<ImageButton>(R.id.idea_button)
        val SupportedBanksButton = findViewById<ImageButton>(R.id.history_button)

        ForgotPasswordButton.setOnClickListener {
            val intent = Intent(this, Tips::class.java)
            startActivity(intent)
        }

        GlobalAvailabilityButton.setOnClickListener {
            val intent = Intent(this, GlobalAccessability::class.java)
            startActivity(intent)
        }

        SupportedCurrenciesButton.setOnClickListener {
            val intent = Intent(this, SupportedCurrencies::class.java)
            startActivity(intent)
        }

        SupportedBanksButton.setOnClickListener {
            val intent = Intent(this, SupportedBanks::class.java)
            startActivity(intent)
        }
    }
}