package org.converter.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinConfiguration

fun initKoin(config: KoinConfiguration? = null) {
    startKoin {
        config?.invoke()
        modules(sharedModule)
    }
}