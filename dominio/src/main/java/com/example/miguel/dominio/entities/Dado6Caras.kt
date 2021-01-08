package com.example.miguel.dominio.entities

class Dado6Caras(
    var valor: Int? = null
) {
    fun tirarDado(): Int {
        valor = (1..6).random()
    }
}