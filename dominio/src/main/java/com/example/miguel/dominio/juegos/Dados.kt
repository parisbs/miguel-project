package com.example.miguel.dominio.juegos

import com.example.miguel.dominio.entities.Dado

interface Dados {
    fun tirarUnDado(caras: Int = 6): Int
}