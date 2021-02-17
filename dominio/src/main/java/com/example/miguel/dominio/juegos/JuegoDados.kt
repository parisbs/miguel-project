package com.example.miguel.dominio.juegos

import com.example.miguel.dominio.entities.Dado

class JuegoDados : Dados {
    override fun tirarUnDado(caras: Int): Int = Dado(caras).tirarDado()
}