package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EleccionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        val nombre = intent.getStringExtra("NOMBRE")
        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        tvBienvenida.text = " Sir $nombre, es el momento que tomes una eleccion..."


    val cbRaenira = findViewById<CheckBox>(R.id.cbRaenira)
        val cbAegon = findViewById<CheckBox>(R.id.cbAegon)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnHincarRodilla = findViewById<Button>(R.id.btnHincarRodilla)

        cbRaenira.setOnCheckedChangeListener { _, _ -> actualizarResultado(cbRaenira, cbAegon, tvResultado) }
        cbAegon.setOnCheckedChangeListener { _, _ -> actualizarResultado(cbRaenira, cbAegon, tvResultado) }

        btnHincarRodilla.setOnClickListener {
            val mensaje = tvResultado.text.toString()
            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("MENSAJE", mensaje)
            startActivity(intent)
        }
    }

    private fun actualizarResultado(cbRaenira: CheckBox, cbAegon: CheckBox, tvResultado: TextView) {
        tvResultado.text = when {
            cbRaenira.isChecked && cbAegon.isChecked -> "Jugar a dos bandas es muy peligroso..."
            cbRaenira.isChecked -> "Has decidido apoyar a una mujer por encima del primogénito..., lo pagarás con sangre.."
            cbAegon.isChecked -> "Has elegido a Aegon contra la voluntad del difunto rey..., Arderás por tu elección... Dracarys!"
            else -> "Si no tomas una decisión no podrás salir de esta encrucijada."
        }
    }
}
