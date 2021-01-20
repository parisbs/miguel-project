package com.example.miguel.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

const val BACKGROUND_CONTEXT = "backgroundContext"

val mainModule = module {
    single<CoroutineContext>(named(BACKGROUND_CONTEXT)) {
        Dispatchers.Default
    }
}