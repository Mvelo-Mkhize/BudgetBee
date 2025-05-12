package com.example.budgetbee

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.yourpackage.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    class ActivitySignupBinding {

    }

    private lateinit var db: AddExpenseActivity.AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AddExpenseActivity.AppDatabase.getDatabase(this)

        binding.btnSignup.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val surname = binding.etSurname.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = UserEntity(name, surname, email, password)

            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().insertUser(user)
                runOnUiThread {
                    Toast.makeText(this@Signup, "Sign up successful", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}
