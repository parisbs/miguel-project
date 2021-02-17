package com.example.miguel.casosdeuso

import com.example.miguel.dominio.entities.Juego
import com.example.miguel.dominio.juegos.ListaDeJuegos
import com.example.miguel.dominio.juegos.MisJuegos

class JuegosDisponibles(
        private val listaDeJuegos: ListaDeJuegos
) {
    operator fun invoke(): List<Juego> =
            listaDeJuegos.quePuedoJugar()
}