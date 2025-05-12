package com.example.budgetbee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ExpenseNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expensename)

        val btnDaily = findViewById<Button>(R.id.btnDaily)
        val btnMonthly = findViewById<Button>(R.id.btnMonthly)

        btnDaily.setOnClickListener {
            startActivity(Intent(this, AddDailyExpenseActivity::class.java))
        }

        btnMonthly.setOnClickListener {
            startActivity(Intent(this, AddMonthlyExpenseActivity::class.java))
        }
    }
}
