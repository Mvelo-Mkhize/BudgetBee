import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.budgetbee.AddExpenseActivity
import com.example.budgetbee.R
import kotlinx.coroutines.launch

class BudgetGoalActivity : AppCompatActivity() {
    private lateinit var db: AddExpenseActivity.AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_goal)

        db = AddExpenseActivity.AppDatabase.getDatabase(this)

        val minInput = findViewById<EditText>(R.id.minGoalInput)
        val maxInput = findViewById<EditText>(R.id.maxGoalInput)
        val saveButton = findViewById<Button>(R.id.saveBudgetButton)

        saveButton.setOnClickListener {
            val minGoal = minInput.text.toString().toDoubleOrNull() ?: 0.0
            val maxGoal = maxInput.text.toString().toDoubleOrNull() ?: 0.0

            lifecycleScope.launch {
                db.dao().setBudgetGoal(BudgetGoal(1, minGoal, maxGoal))
                Toast.makeText(this@BudgetGoalActivity, "Goals saved!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
