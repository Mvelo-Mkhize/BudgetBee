package com.example.budgetbee

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class AddCategoryActivity : AppCompatActivity() {

    private lateinit var categoryNameEditText: EditText
    private lateinit var saveCategoryButton: Button
    private lateinit var categoryListLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        categoryNameEditText = findViewById(R.id.categoryNameEditText)
        saveCategoryButton = findViewById(R.id.saveCategoryButton)
        categoryListLayout = findViewById(R.id.categoryListLayout)

        // Remove "Utilities" if present (this would only matter if loaded from DB)
        removeUtilitiesIfPresent()

        saveCategoryButton.setOnClickListener {
            val categoryName = categoryNameEditText.text.toString().trim()
            if (categoryName.isNotEmpty()) {
                addCategoryToList(categoryName)
                categoryNameEditText.text.clear()
                Toast.makeText(this, "Category Added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a category name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addCategoryToList(name: String) {
        val textView = TextView(this).apply {
            text = "- $name"
            textSize = 18f
            setTextColor(ContextCompat.getColor(this@AddCategoryActivity, android.R.color.holo_red_dark))
            setPadding(4, 8, 4, 8)
        }
        categoryListLayout.addView(textView)
    }

    private fun removeUtilitiesIfPresent() {
        val utilitiesText = "- Utilities"
        for (i in 0 until categoryListLayout.childCount) {
            val view = categoryListLayout.getChildAt(i)
            if (view is TextView && view.text.toString() == utilitiesText) {
                categoryListLayout.removeView(view)
                break
            }
        }
    }
}
