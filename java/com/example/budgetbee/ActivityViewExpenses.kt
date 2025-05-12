package com.example.budgetbee

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ViewExpensesActivity : AppCompatActivity() {

    private lateinit var totalAmountTextView: TextView
    private lateinit var submitViewButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_expenses)

        totalAmountTextView = findViewById(R.id.totalAmountTextView)
        submitViewButton = findViewById(R.id.submitViewButton)

        // Handle Submit button click
        submitViewButton.setOnClickListener {
            // Implement your button click logic here
            // For example, save data or go back to previous screen
        }

        // Update the total amount dynamically (example)
        updateTotalAmount()
    }

    private fun updateTotalAmount() {
        // This can be dynamically calculated based on your data
        val totalAmount = 2200 + 700 + 450 + 100  // Sum of expenses
        totalAmountTextView.text = "Total Spent: R$totalAmount"
    }
}
