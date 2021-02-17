package com.example.miguel.di

import com.example.miguel.casosdeuso.JuegosDisponibles
import com.example.miguel.casosdeuso.TirarUnDado
import com.example.miguel.dominio.juegos.JuegoDados
import org.koin.dsl.module

val casosDeUsoModule = module {

    factory {
        JuegosDisponibles(
                get()
        )
    }

    factory {
        TirarUnDado(
            JuegoDados()
        )
    }
}
