package com.example.miguel.dominio.juegos

import com.example.miguel.dominio.entities.Dado6Caras
import com.example.miguel.dominio.juegos.Dados

class JuegoDados : Dados {
    override fun tiradaDado6Caras(): Dado6Caras = Dado6Caras()
}