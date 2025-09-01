package com.fredcodecrafts.week1

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()
            val studentInput = findViewById<TextInputEditText>(R.id.student_input)
                ?.text.toString().trim()

            if (nameInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply { setGravity(Gravity.CENTER, 0, 0); show() }
            } else if (studentInput.length != 11) {
                Toast.makeText(this, getString(R.string.student_error), Toast.LENGTH_LONG)
                    .apply { setGravity(Gravity.CENTER, 0, 0); show() }
            } else {
                nameDisplay?.text =
                    "${getString(R.string.name_greet)} $nameInput\nStudent No: $studentInput"
            }
        }
    }
}
