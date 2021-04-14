package com.example.miguel.principal

import com.example.miguel.di.BACKGROUND_CONTEXT
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.math.sin

val mainModule = module {
    single<MainViewModel> {
        MainViewModel(
            get(named(BACKGROUND_CONTEXT)),
            get()
        )
    }
}