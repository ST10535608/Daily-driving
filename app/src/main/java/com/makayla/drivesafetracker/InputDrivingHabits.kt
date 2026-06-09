// Makayla Walkerley
// ST10535608

package com.makayla.drivesafetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputDrivingHabits : AppCompatActivity() {

    var days = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    var hoursDriven = Array( 7 ){ 0 }

    var restStops = Array( 7 ) { 0 }

    var prevNightHoursSlept = Array( 7 ) { 0 }

    var notes = Array( 7 ) { "" }

    var index = 0

    lateinit var edtDriven: EditText
    lateinit var edtStops: EditText
    lateinit var edtHrsSlept: EditText
    lateinit var edtNotes: EditText

    lateinit var txtWeekday: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_driving_habits)

        txtWeekday = findViewById(R.id.txtWeekday)
        edtDriven = findViewById(R.id.edtTxtHrsDriven)
        edtStops = findViewById(R.id.edtTxtStops)
        edtHrsSlept = findViewById(R.id.edtTxtHrsSlept)
        edtNotes = findViewById(R.id.edtTxtNotes)

        val btnNextDay = findViewById<Button>(R.id.btnNxtDay)
        val btnClearData = findViewById<Button>(R.id.btnClearData)
        val btnDetailScreen = findViewById<Button>(R.id.btnDetailedView)

        txtWeekday.text = days[index]

        btnNextDay.setOnClickListener {
            val hrsDriven = edtDriven.text.toString()
            val rstStops = edtStops.text.toString()
            val hrsSlept = edtHrsSlept.text.toString()
            val notesInput = edtNotes.text.toString()

            if (hrsDriven.isEmpty() || rstStops.isEmpty() || hrsSlept.isEmpty() || notesInput.isEmpty()) {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            fillArrays()

            if (index < days.count() - 1) {
                index ++
                txtWeekday.text = days[index]
                edtDriven.text.clear()
                edtStops.text.clear()
                edtHrsSlept.text.clear()
                edtNotes.text.clear()
                Toast.makeText(this, "Day saved! Now enter ${days[index]}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "All 7 days entered! Tap 'See Detailed View'", Toast.LENGTH_SHORT).show()
            }

        }

        btnClearData.setOnClickListener {
            clearData()

        }

        btnDetailScreen.setOnClickListener {
            val intent = Intent(this, DetailsScreen::class.java)
            intent.putExtra("total", calculateTotal())
            intent.putExtra("average", calculateAverageSleep())
            intent.putExtra("highest", findMostDrivingDay())
            startActivity(intent)
        }

    }

    fun fillArrays() {
        val hrsDriven = edtDriven.text.toString()
        val rstStops = edtStops.text.toString()
        val hrsSlept = edtHrsSlept.text.toString()
        val notesInput = edtNotes.text.toString()

        if (hrsDriven.isEmpty() || rstStops.isEmpty() || hrsSlept.isEmpty() || notesInput.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            return
        }
        hoursDriven[index] = hrsDriven.toInt()
        restStops[index] = rstStops.toInt()
        prevNightHoursSlept[index] = hrsSlept.toInt()
        notes[index] = notesInput
    }


    fun clearData() {
        hoursDriven = Array (7) { 0 }
        restStops = Array(7) { 0 }
        prevNightHoursSlept = Array(7) { 0 }
        notes = Array(7) { "" }
        edtDriven.text.clear()
        edtStops.text.clear()
        edtHrsSlept.text.clear()
        edtNotes.text.clear()
        index = 0
        txtWeekday.text = days[0]
        Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
    }

    fun calculateTotal(): Int {
        var total = 0
        var counter = 0
        while (counter < hoursDriven.count()) {
            total += hoursDriven[counter]
            counter++
        }
        return total
    }

    fun calculateAverageSleep(): Double {
        var total = 0
        var counter = 0
        while (counter < prevNightHoursSlept.count()){
            total += prevNightHoursSlept[counter]
            counter++
        }
        return total.toDouble()/prevNightHoursSlept.count()
    }

    fun findMostDrivingDay(): String {
        var max = hoursDriven[0]
        var maxIndex = 0
        var counter = 1
        while (counter < hoursDriven.count()){
            if (hoursDriven[counter] > max){
                max = hoursDriven[counter]
            }
            counter++
        }
        return "${days[maxIndex]} ($max hrs)"
    }

}