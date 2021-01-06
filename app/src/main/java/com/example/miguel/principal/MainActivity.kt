package com.example.miguel.principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.miguel.R
import com.example.miguel.segundo.SecondActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var boton1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById<EditText>(R.id.nombre)
        boton1 = findViewById<Button>(R.id.boton1)

        boton1?.setOnClickListener { view ->
            Intent(this, SecondActivity::class.java).apply {
                putExtra("nombre", nombre.text?.toString())
                startActivity(this)
            }
        }
    }
}