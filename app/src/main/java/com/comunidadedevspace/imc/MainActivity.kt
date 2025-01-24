package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get text input for Height and associate with a variable for UI component<EditText>

        val edtHeight = findViewById<TextInputEditText>(R.id.edtInputHeight)

        // Get text input for Weight and associate with a variable for UI component<EditText>

        val edtWeight = findViewById<TextInputEditText>(R.id.edtWeight)

        // Get caculate button

        val btnCalculate = findViewById<Button>(R.id.calculate_button)

        btnCalculate.setOnClickListener {

            val weight = edtWeight.text
            val height = edtHeight.text
        }
    }
}