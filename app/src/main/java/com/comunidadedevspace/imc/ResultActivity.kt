package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Create a variable to keep the intent key

const val KEY_RESULT_BMI = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // Get and display the result and IMC classification for UI component

        val result = intent.getFloatExtra(KEY_RESULT_BMI, 0f)

        val resultIMC = findViewById<TextView>(R.id.tv_result)

        val classificationBMI = findViewById<TextView>(R.id.tv_classification)

        resultIMC.text = result.toString()

        // Logic to BMI classification
        var classification: String? = if (result <= 18.5f){
            "UNDERWEIGHT"
        } else if (result > 18.5f && result <= 24.9f){
            "NORMAL"
        } else if (result > 25.0f && result <= 29.9f){
            "OVERWEIGHT"
        } else if (result > 30.0f && result <= 34.9f){
            "OBESE"
        } else {
            "EXTREMELY OBESE"
        }

        classificationBMI.text = classification
    }
}