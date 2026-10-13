package com.example.shitovka_pr_31_04

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI

class SecondActivity : AppCompatActivity() {

    private var selectedShape = "Круг" 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val spinner = findViewById<Spinner>(R.id.spinnerShapes)
        val imageView = findViewById<ImageView>(R.id.imageViewShape)
        val editValue = findViewById<EditText>(R.id.editTextValue)
        val btnCalculate = findViewById<Button>(R.id.buttonCalculate)

        val shapes = arrayOf("Круг", "Треугольник")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        imageView.setImageResource(R.drawable.image3)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        imageView.setImageResource(R.drawable.image3)
                        editValue.hint = "Введите периметр P"
                        selectedShape = "Круг"
                    }
                    1 -> {
                        imageView.setImageResource(R.drawable.image4)
                        editValue.hint = "Введите сторону a"
                        selectedShape = "Треугольник"
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        btnCalculate.setOnClickListener {
            val valueStr = editValue.text.toString().trim()

            if (valueStr.isEmpty()) {
                Toast.makeText(this, "Введите значение!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val value = valueStr.toDoubleOrNull()
            if (value == null) {
                Toast.makeText(this, "Введите корректное число!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = if (spinner.selectedItemPosition == 0) {
                value / (2 * PI)
            } else {
                3 * value
            }

            val intent = Intent(this, FierdActivity::class.java)
            intent.putExtra("SHAPE_NAME", selectedShape)
            intent.putExtra("RESULT", String.format("%.2f", result))
            startActivity(intent)
        }
    }
}
