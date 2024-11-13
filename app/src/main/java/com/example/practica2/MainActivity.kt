package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnAceptar = findViewById<Button>(R.id.btnAceptar)

        btnAceptar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Introducir tu nombre", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, EleccionActivity::class.java)
                intent.putExtra("NOMBRE", nombre)
                startActivity(intent)
            }

        }
    }
}
