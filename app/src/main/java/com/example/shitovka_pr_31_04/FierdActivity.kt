package com.example.shitovka_pr_31_04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FierdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fierd)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextResult = findViewById<EditText>(R.id.editTextResult)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        // Получаем данные из Intent
        val shapeName = intent.getStringExtra("SHAPE_NAME") ?: "Фигура"
        val result = intent.getStringExtra("RESULT") ?: "0.0"

        // Отображаем данные в полях
        editTextName.setText(shapeName)
        editTextResult.setText(result)

        // Делаем поля недоступными для редактирования (только для чтения)
        editTextName.isEnabled = false
        editTextResult.isEnabled = false

        // Кнопка "Регистрация" - закрываем Activity и возвращаемся на второй экран
        buttonRegister.setOnClickListener {
            finish()
        }
    }
}