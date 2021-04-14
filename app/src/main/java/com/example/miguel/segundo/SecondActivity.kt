package com.example.miguel.segundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.miguel.R
import org.koin.android.viewmodel.ext.android.viewModel

class SecondActivity : AppCompatActivity() {

    private val secondViewModel: SecondViewModel by viewModel()

    private lateinit var saludoPersonalizado: TextView
    private lateinit var tirarDadoSeisCaras: Button
    private lateinit var tirarDado12Caras: Button

    // Ciclo de vida: se ejecuta primero
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("Segunda", "onCreate")

        subscribeTirada()

        saludoPersonalizado = findViewById<TextView>(R.id.saludoPersonalizado)
        tirarDadoSeisCaras = findViewById<Button>(R.id.tirarDadoSeisCaras)
        tirarDado12Caras = findViewById<Button>(R.id.tirarDado12Caras)

                intent?.extras?.get("nombre")?.also { nombre ->
            saludoPersonalizado.text = getString(
                R.string.second_saludo_personalizado,
                nombre.toString()
            )
        }

        tirarDadoSeisCaras.setOnClickListener {
            secondViewModel.lanzarLosDados(6)
        }

        tirarDado12Caras.setOnClickListener {
            secondViewModel.lanzarLosDados(12)
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

    private fun subscribeTirada() = secondViewModel.tirada.observe(this, Observer {
        when (val resultado = it) {
            is SecondViewModel.ResultadoDados.Correcto -> {
                saludoPersonalizado.text = resultado.valorDeDado.toString()
                saludoPersonalizado.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED)
            }
            is SecondViewModel.ResultadoDados.Error -> {
                Toast.makeText(
                    this,
                    "Se perdio el dado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    })
}