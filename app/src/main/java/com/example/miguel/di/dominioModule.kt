package com.example.miguel.di

import com.example.miguel.dominio.juegos.ListaDeJuegos
import com.example.miguel.dominio.juegos.MisJuegos
import org.koin.dsl.module

val dominioModule = module {
    single<ListaDeJuegos> {
        MisJuegos(
                get()
        )
    }
}