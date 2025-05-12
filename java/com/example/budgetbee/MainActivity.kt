package com.example.budgetbee

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var container: FrameLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tabLayout = findViewById(R.id.tabLayout)
        container = findViewById(R.id.tabContainer)


        tabLayout.addTab(tabLayout.newTab().setText("Dashboard"))
        tabLayout.addTab(tabLayout.newTab().setText("History"))
        tabLayout.addTab(tabLayout.newTab().setText("Notification"))
        tabLayout.addTab(tabLayout.newTab().setText("Profile"))

        //LOAD DEFAULT VIEW
        showDashboard()

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> showDashboard()  //selectionn upon possitions
                    1 -> showHistory()
                    2 -> showNotification()
                    3 -> showProfile()
                }
            }

        })

    }

    private fun showDashboard(){
        val view = layoutInflater.inflate(R.layout.activity_home, null);
        container.removeAllViews()
        container.addView(view)
    }
    private fun showHistory(){
        val view = layoutInflater.inflate(R.layout.activity_transaction_history, null);
        container.removeAllViews()
        container.addView(view)
    }
    private fun showNotification(){
        val view = layoutInflater.inflate(R.layout.activity_notification_setting, null);
        container.removeAllViews()
        container.addView(view)
    }
    private fun showProfile(){
        val view = layoutInflater.inflate(R.layout.activity_profile_redirect, null);
        container.removeAllViews()
        container.addView(view)
    }
}