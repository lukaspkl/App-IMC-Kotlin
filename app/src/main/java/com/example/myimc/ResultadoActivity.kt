package com.example.myimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {


    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.textPeso)
        textAltura = findViewById(R.id.textAltura)
        textResultado = findViewById(R.id.textResultado)

        val bundle = intent.extras
        if (bundle != null){

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado : $peso kg"
            textAltura.text = "Altura informada : $altura M"

            val imc = peso / (altura * altura)

            val resultado = if (imc < 18.5){
                "baixo"
            } else if (imc in 18.5 .. 24.9){
                "Normal"
            }else if (imc in 25.0 .. 29.9){
                "SobrePeso"
            }else {
                "Obeso"
            }
            textResultado.text = resultado
        }
    }
}