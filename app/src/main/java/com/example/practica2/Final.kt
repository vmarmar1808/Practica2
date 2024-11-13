package com.example.practica2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val tvFinal = findViewById<TextView>(R.id.tvFinal)
        val btnSalir = findViewById<Button>(R.id.btnSalir)

        val mensaje = intent.getStringExtra("MENSAJE")
        tvFinal.text = mensaje

        btnSalir.setOnClickListener {
            finishAffinity()  // Cierra la aplicación completamente
        }
    }
}
