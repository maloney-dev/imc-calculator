package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Force light mode
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get text input for Height and associate with a variable for UI component<EditText>

        val edtHeight = findViewById<TextInputEditText>(R.id.edtInputHeight)

        // Get text input for Weight and associate with a variable for UI component<EditText>

        val edtWeight = findViewById<TextInputEditText>(R.id.edtWeight)

        // Get caculate button

        val btnCalculate = findViewById<Button>(R.id.calculate_button)

        btnCalculate.setOnClickListener {

            val strWeight: String = edtWeight.text.toString()
            val strHeight: String = edtHeight.text.toString()

            if (strHeight == "" || strWeight == "") {
                // Show user a mensage

                Snackbar.make(
                    edtWeight,
                    "Fill in all fields.",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            else {

                val weight = edtWeight.text.toString().toFloat()
                val height = edtHeight.text.toString().toFloat() / 100

                val height2 = height * height
                val result = weight / height2

                // Navigate to the next page
                // Create new page layout
                // Get data (results) to next page

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_BMI, result)
                startActivity(intent)

                println(result)
            }
        }
    }
}