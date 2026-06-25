//ST10535608
//Makayla Walkerley
package com.makayla.drivesafetracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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
        val total = bundle?.getDouble("total") ?: 0.0
        val highestDriven = bundle?.getString("highest") ?: ""
        val averageSleep = bundle?.getDouble("average") ?: 0.0

        val totalFormatted = String.format("%.1f", total)
        val avgFormatted = String.format("%.1f", averageSleep)

        txtHoursTotal.text = "Total hours driven: $totalFormatted hrs"
        txtHighestDriving.text = "Most driving: $highestDriven"
        txtAvgSleep.text = "Average sleep: $avgFormatted hrs"

        if (total > 40) {
            txtFeedback.text = "You are driving too much. Take regular breaks."
        } else if (total >= 20) {
            txtFeedback.text = "Reasonable week. Keep monitoring your rest stops."
        } else {
            txtFeedback.text = "Great job! You are managing your driving safely."
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}