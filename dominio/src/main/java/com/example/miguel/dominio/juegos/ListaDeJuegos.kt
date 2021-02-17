package com.example.miguel.dominio.juegos

import com.example.miguel.dominio.entities.Juego

interface ListaDeJuegos {
    fun quePuedoJugar(): List<Juego>
}