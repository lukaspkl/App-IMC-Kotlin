package com.example.myimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btnCalcular)
        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)


        btnCalcular.setOnClickListener {

            val intent = Intent(this,ResultadoActivity::class.java)
            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()){

                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }
    }
}