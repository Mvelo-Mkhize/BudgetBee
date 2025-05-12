package com.example.budgetbee

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LeaderBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader_board)

        val leaderboardTextView = findViewById<TextView>(R.id.textViewLeaderboardList)

        val leaders = listOf(
            "1. Asang Mkhize - 53844397",
            "2. Jasmine H - 528441489",
            "3. Arning Malu - 51544534",
            "4. Huga Briskly - 44366597",
            "5. Dave Radding - 8359044",
            "6. Jogn Vugvi - 5699798",
            "7. 573774 - No Name Provided",
            "8. Malu Maku - ID Not Provided",
            "9. Sung Jiwu - 4859697",
            "10. A - ID Not Provided"
        )

        val numberedList = leaders.joinToString("\n\n")
        leaderboardTextView.text = numberedList
    }
}
