package com.example.budgetbee


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RedeemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redeem)

        // Points text is static here, but in real apps, you would fetch this from a database or shared preferences
        val pointsText: TextView = findViewById(R.id.availablePoints)
        pointsText.text = "Available Points: R 9,420"

        val historyButton: Button = findViewById(R.id.historyButton)
        historyButton.setOnClickListener {
            // For now, just a toast. You can navigate to a real history activity if needed.
            Toast.makeText(this, "Showing redeem history (to be implemented)", Toast.LENGTH_SHORT).show()
        }
    }
}
