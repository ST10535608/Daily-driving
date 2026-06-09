// Makayla Walkerley
// ST10535608
package com.makayla.drivesafetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnStartActivity = findViewById<Button>(R.id.btnStart)
        val btnCloseApp = findViewById<Button>(R.id.btnCloseApp)

        // This button will allow user to close app
        btnCloseApp.setOnClickListener {
            finishAffinity()
        }

        // This button will allow user to move to the Main Screen
        btnStartActivity.setOnClickListener {
            val intent = Intent(this, InputDrivingHabits::class.java)
            startActivity(intent)
        }
    }
}