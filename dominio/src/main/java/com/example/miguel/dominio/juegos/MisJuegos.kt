package com.example.miguel.dominio.juegos

import android.content.Context
import com.example.miguel.dominio.R
import com.example.miguel.dominio.entities.Juego

class MisJuegos(
        private val context: Context
) : ListaDeJuegos {

    override fun quePuedoJugar(): List<Juego> = listOf<Juego>(
            Juego(
                    id = 0,
                    nombre = context.getString(R.string.juego_dados),
                    descripcion = context.getString(R.string.juego_dados_descripcion)
            ),
            Juego(
                    id = 1,
                    nombre = context.getString(R.string.juego_moneda),
                    descripcion = context.getString(R.string.juego_moneda_descripcion)
            )
    )
}