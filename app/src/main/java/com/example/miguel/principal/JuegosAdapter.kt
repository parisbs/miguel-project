package com.example.miguel.principal

import android.view.View
import android.widget.TextView
import com.blindoapp.uitools.recyclerview.Adapter
import com.blindoapp.uitools.recyclerview.ViewHolder
import com.example.miguel.R
import com.example.miguel.dominio.entities.Juego

class JuegosAdapter(
    private val onClickListener: (Juego) -> Unit
) : Adapter<Juego>() {

    override fun bind(item: Juego, viewHolder: ViewHolder) {
        viewHolder.itemView.apply {
            findViewById<TextView>(R.id.nombre)!!.text = item.nombre
            findViewById<TextView>(R.id.description)!!.text = item.descripcion
            setOnClickListener { onClickListener(item) }
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_juego
}