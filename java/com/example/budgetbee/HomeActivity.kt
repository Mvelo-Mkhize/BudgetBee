package com.example.budgetbee


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var balanceTextView: TextView
    private lateinit var incomeTextView: TextView
    private lateinit var expenseTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize views
        balanceTextView = findViewById(R.id.balanceTextView)
        incomeTextView = findViewById(R.id.incomeTextView)
        expenseTextView = findViewById(R.id.expenseTextView)

        // Set up navigation buttons
        findViewById<Button>(R.id.statsButton).setOnClickListener {
            startActivity(Intent(this, StatsActivity::class.java))
        }

        findViewById<Button>(R.id.walletButton).setOnClickListener {
            startActivity(Intent(this, WalletActivity::class.java))
        }

        findViewById<Button>(R.id.profileButton).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

    }

}