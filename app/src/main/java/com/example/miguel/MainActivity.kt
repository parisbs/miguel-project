package com.example.miguel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var texto1: TextView
    private lateinit var botonimagen2: ImageButton
    private lateinit var boton1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto1 = findViewById<TextView>(R.id.texto1)
        botonimagen2 = findViewById<ImageButton>(R.id.botonimagen2)
        boton1 = findViewById<Button>(R.id.boton1)

        boton1?.setOnClickListener { view ->
            texto1?.text = getString(R.string.main_presionaste_boton1)
            texto1?.requestFocus()
            texto1?.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
        }

        botonimagen2?.setOnClickListener { view ->
            texto1?.text = getString(R.string.main_presionaste_otro_boton)
            texto1?.requestFocus()
            texto1?.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
        }
    }
}