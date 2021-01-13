package com.example.miguel.segundo

import org.koin.dsl.module

val secondModule = module {
    single<SecondViewModel> {
        SecondViewModel(
            get()
        )
    }
}