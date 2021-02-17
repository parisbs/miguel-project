package com.example.miguel.casosdeuso

import com.example.miguel.dominio.entities.Dado
import com.example.miguel.dominio.juegos.Dados

class TirarUnDado(
    private val dados: Dados
) {
    operator fun invoke(caras: Int = 6): Int =
            dados.tirarUnDado(caras)
}