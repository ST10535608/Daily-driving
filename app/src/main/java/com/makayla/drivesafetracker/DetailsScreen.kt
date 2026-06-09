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

        val bundle = intent.extras
        val total = bundle?.getInt("total") ?: 0
        val highestDriven = bundle?.getInt("highest")?: 0
        val averageSleep = bundle?.getInt("average")?: 0

    }
}