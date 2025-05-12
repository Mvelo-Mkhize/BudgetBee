package com.example.budgetbee


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WalletActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        // Set up payment methods RecyclerView
        val paymentMethodsRecyclerView = findViewById<RecyclerView>(R.id.paymentMethodsRecyclerView)
        paymentMethodsRecyclerView.layoutManager = LinearLayoutManager(this)

        val paymentMethods = listOf(
            PaymentMethod("VISA •••• 4567", "Primary", R.drawable.ic_visa),
            PaymentMethod("MasterCard •••• 8910", "Secondary", R.drawable.ic_mastercard),
            PaymentMethod("PayPal", "Linked", R.drawable.ic_paypal)
        )

        paymentMethodsRecyclerView.adapter = PaymentMethodAdapter(paymentMethods)

        // Back button
        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }
    }
}

// PaymentMethod data class
data class PaymentMethod(val cardNumber: String, val type: String, val icon: Int)



class PaymentMethodAdapter(private val paymentMethods: List<PaymentMethod>) :
    RecyclerView.Adapter<PaymentMethodAdapter.PaymentMethodViewHolder>() {

    class PaymentMethodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.paymentMethodIcon)
        val cardNumber: TextView = itemView.findViewById(R.id.paymentMethodNumber)
        val type: TextView = itemView.findViewById(R.id.paymentMethodType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment_method, parent, false)
        return PaymentMethodViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentMethodViewHolder, position: Int) {
        val paymentMethod = paymentMethods[position]
        holder.icon.setImageResource(paymentMethod.icon)
        holder.cardNumber.text = paymentMethod.cardNumber
        holder.type.text = paymentMethod.type
    }

    override fun getItemCount() = paymentMethods.size
}