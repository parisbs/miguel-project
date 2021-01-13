package com.example.miguel.di

import com.example.miguel.casosdeuso.TirarUnDadoDeSeisCaras
import com.example.miguel.dominio.juegos.JuegoDados
import org.koin.dsl.module

val casosDeUsoModule = module {
    factory {
        TirarUnDadoDeSeisCaras(
            JuegoDados()
        )
    }
}
