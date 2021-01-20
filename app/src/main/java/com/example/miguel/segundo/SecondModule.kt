package com.example.miguel.segundo

import com.example.miguel.di.BACKGROUND_CONTEXT
import org.koin.core.qualifier.named
import org.koin.dsl.module

val secondModule = module {
    single<SecondViewModel> {
        SecondViewModel(
            get(named(BACKGROUND_CONTEXT)),
            get()
        )
    }
}