package com.example.budgetbee

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Set up profile options RecyclerView
        val profileOptionsRecyclerView = findViewById<RecyclerView>(R.id.profileOptionsRecyclerView)
        profileOptionsRecyclerView.layoutManager = LinearLayoutManager(this)

        val profileOptions = listOf(
            ProfileOption("Personal Information", R.drawable.ic_person),
            ProfileOption("Notification Settings", R.drawable.ic_notifications),
            ProfileOption("Security", R.drawable.ic_security),
            ProfileOption("Help & Support", R.drawable.ic_help),
            ProfileOption("About", R.drawable.ic_info)
        )

        profileOptionsRecyclerView.adapter = ProfileOptionAdapter(profileOptions)

        // Back button
        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }
    }
}

// ProfileOption data class
data class ProfileOption(val title: String, val icon: Int)




class ProfileOptionAdapter(private val profileOptions: List<ProfileOption>) :
    RecyclerView.Adapter<ProfileOptionAdapter.ProfileOptionViewHolder>() {

    class ProfileOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.profileOptionIcon)
        val title: TextView = itemView.findViewById(R.id.profileOptionTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileOptionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_option, parent, false)
        return ProfileOptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileOptionViewHolder, position: Int) {
        val profileOption = profileOptions[position]
        holder.icon.setImageResource(profileOption.icon)
        holder.title.text = profileOption.title
    }

    override fun getItemCount() = profileOptions.size
}