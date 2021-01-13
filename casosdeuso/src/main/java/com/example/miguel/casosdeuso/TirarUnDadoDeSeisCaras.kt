package com.example.miguel.casosdeuso

import com.example.miguel.dominio.entities.Dado6Caras
import com.example.miguel.dominio.juegos.Dados

class TirarUnDadoDeSeisCaras(
    private val dados: Dados
) {
    operator fun invoke(): Dado6Caras =
            dados.tiradaDado6Caras()
}