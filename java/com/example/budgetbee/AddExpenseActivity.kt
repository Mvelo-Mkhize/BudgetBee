package com.example.budgetbee

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

////class AddExpenseActivity<EditText : View?, Button : View?, ImageView : View?> : AppCompatActivity() {
//  //  private lateinit var db: AppDatabase
//
//    //class AppDatabase {
//        fun dao(): Any {
//
//        }
//
//        companion object {
//            fun getDatabase(expenseActivity: BudgetGoalActivity): AddExpenseActivity<Any?, Any?, Any?>.AppDatabase {
//
//            }
//        }
//
//    }
//
//    private lateinit var categorySpinner: Spinner
//    private var imagePath: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_expense)
//
//        db = AppDatabase.getDatabase(this)
//
//        val dateInput = findViewById<EditText>(R.id.dateInput)
//        val startInput = findViewById<EditText>(R.id.startTimeInput)
//        val endInput = findViewById<EditText>(R.id.endTimeInput)
//        val descInput = findViewById<EditText>(R.id.descriptionInput)
//        val imageBtn = findViewById<Button>(R.id.pickImageButton)
//        val saveBtn = findViewById<Button>(R.id.saveExpenseButton)
//        val imageView = findViewById<ImageView>(R.id.expenseImageView)
//        categorySpinner = findViewById(R.id.categorySpinner)
//
//        if (dateInput != null) {
//            dateInput.setOnClickListener { pickDate(dateInput) }
//        }
//        if (startInput != null) {
//            startInput.setOnClickListener { pickTime(startInput) }
//        }
//        if (endInput != null) {
//            endInput.setOnClickListener { pickTime(endInput) }
//        }
//
//        db.dao().getAllCategories().observe(this) { categories ->
//            categorySpinner.adapter = ArrayAdapter(
//                this,
//                android.R.layout.simple_spinner_item,
//                categories.map { it.name }
//            )
//        }
//
//        imageBtn.setOnClickListener {
//            ImagePicker.with(this)
//                .crop()
//                .compress(1024)
//                .maxResultSize(1080, 1080)
//                .start { result ->
//                    imagePath = result?.data?.data?.toString()
//                    imageView.setImageURI(result?.data?.data)
//                }
//        }
//
//        saveBtn.setOnClickListener {
//            val date = dateInput.text.toString()
//            val start = startInput.text.toString()
//            val end = endInput.text.toString()
//            val desc = descInput.text.toString()
//            val selectedCategory = categorySpinner.selectedItem.toString()
//
//            db.dao().getAllCategories().observe(this) { list ->
//                val categoryId = list.find { it.name == selectedCategory }?.id ?: return@observe
//                val expense = Expense(0, date, start, end, desc, categoryId, imagePath)
//                lifecycleScope.launch {
//                    db.dao().insertExpense(expense)
//                    finish()
//                }
//            }
//        }
//    }
//
//    private fun pickDate(edit: EditText) {
//        val c = Calendar.getInstance()
//        DatePickerDialog(this, { _, y, m, d -> edit.setText("$d/${m+1}/$y") }, c[Calendar.YEAR], c[Calendar.MONTH], c[Calendar.DAY_OF_MONTH]).show()
//    }
//
//    private fun pickTime(edit: EditText) {
//        val c = Calendar.getInstance()
//        TimePickerDialog(this, { _, h, m -> edit.setText(String.format("%02d:%02d", h, m)) }, c[Calendar.HOUR_OF_DAY], c[Calendar.MINUTE], true).show()
//    }
//}
