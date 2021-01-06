package com.example.miguel.segundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.miguel.R

class SecondActivity : AppCompatActivity() {

    private lateinit var saludoPersonalizado: TextView

    // Ciclo de vida: se ejecuta primero
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("Segunda", "onCreate")

        saludoPersonalizado = findViewById<TextView>(R.id.saludoPersonalizado)

                intent?.extras?.get("nombre")?.also { nombre ->
            saludoPersonalizado.text = getString(
                R.string.second_saludo_personalizado,
                nombre.toString()
            )
        }
    }

    // Ciclo de vida: segunda en ejecutarse
    override fun onStart() {
        super.onStart()
        Log.i("Segunda", "onStart")
    }

    // Ciclo de vida: último en ejecutarse durante la inicialización
    override fun onResume() {
        super.onResume()
        Log.i("Segunda", "onResume")
    }

    // Ciclo de vida: primero en ejecutarse al cierre
    override fun onPause() {
        super.onPause()
        Log.i("Segunda", "onPause")
    }

    // Ciclo de vida: segundo en ejecutarse antes de destruir
    // Si se pasa a segundo plano sin destruir la actividad el ciclo de vida se queda aquí
    override fun onStop() {
        super.onStop()
        Log.i("Segunda", "onStop")
    }

    // Ciclo de vida: última en ejecutarse al cierre y destruye por completo la instancia
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Segunda", "onDestroy")
    }
}