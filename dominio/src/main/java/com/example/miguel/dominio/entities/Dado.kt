package com.example.miguel.dominio.entities

class Dado(
    val caras: Int = 6
) {

    init {
        if (caras <= 2) {
            throw IllegalArgumentException("Un dado no puede tener menos de 3 caras")
        }
    }

    fun tirarDado(): Int {
        return (1..caras).random()
    }
}