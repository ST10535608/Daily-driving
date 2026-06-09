//ST10535608
//Makayla Walkerley
package com.makayla.drivesafetracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_screen)

        val txtResults = findViewById<TextView>(R.id.txtResults)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val txtHoursTotal = findViewById<TextView>(R.id.txtHoursTotal)
        val txtHighestDriving = findViewById<TextView>(R.id.txtHighestDriving)
        val txtAvgSleep = findViewById<TextView>(R.id.txtAvgSleep)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)

        val bundle = intent.extras
        val total = bundle?.getInt("total") ?: 0
        val highestDriven = bundle?.getString("highest")?: ""
        val averageSleep = bundle?.getDouble("average")?: 0.0

        txtHoursTotal.text = "Total hours driven: $total hrs"
        txtHighestDriving.text = "Most driving: $highestDriven"
        val avgFormatted = String.format("%1f", averageSleep)
        txtAvgSleep.text = "Average sleep: $avgFormatted hrs"

        if (total > 40) {
            txtFeedback.text = "You are driving too much. Take regular breaks."
        } else if (total >= 20) {
            txtFeedback.text = "Reasonable week. Keep monitoring your rest stops."
        } else {
            txtFeedback.text = "Great job! You are managing your driving safely."
        }

        // Back button
        btnBack.setOnClickListener {
            finish()
        }

    }
}