package com.example.miguel.principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.accessibility.AccessibilityEvent
import android.widget.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.miguel.R
import com.example.miguel.dominio.entities.Juego
import com.example.miguel.segundo.SecondActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var nombre: EditText
    private lateinit var recyclerView: RecyclerView

    private val juegosAdapter: JuegosAdapter = JuegosAdapter({ juego ->
        abrirJuego(juego)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById<EditText>(R.id.nombre)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            adapter = juegosAdapter
        }

        subscribeListaDeJuegos()
    }

    private fun subscribeListaDeJuegos() = mainViewModel.juegos.observe(this, Observer {
        when (val result = it) {
            is MainViewModel.ListaDeJuegos.Correcto -> {
                juegosAdapter.items = result.juegos.toMutableList()
            }
            is MainViewModel.ListaDeJuegos.Error -> {
                Toast.makeText(
                    this,
                    "Lista vacia",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    })

    private fun abrirJuego(juego: Juego) {
        Intent(this, SecondActivity::class.java).apply {
            putExtra("juego", juego)
            startActivity(this)
        }
    }
}