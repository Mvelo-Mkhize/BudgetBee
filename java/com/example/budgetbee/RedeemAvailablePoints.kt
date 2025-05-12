package com.example.budgetbee

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RedeemAvailablePoints : AppCompatActivity() {

    private var availablePoints = 9420
    private val starbucksCost = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redeem_available_points)

        val textViewPoints = findViewById<TextView>(R.id.textViewAvailablePoints)
        val btnRedeemStarbucks = findViewById<Button>(R.id.btnRedeemStarbucks)

        textViewPoints.text = "Available Points: $availablePoints"

        btnRedeemStarbucks.setOnClickListener {
            if (availablePoints >= starbucksCost) {
                availablePoints -= starbucksCost
                textViewPoints.text = "Available Points: $availablePoints"
                Toast.makeText(this, "You redeemed a Free Coffee at Starbucks!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Not enough points to redeem this perk.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
