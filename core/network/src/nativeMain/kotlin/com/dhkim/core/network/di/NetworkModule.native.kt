package com.dhkim.core.network.di

import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {
    single { Darwin.create() }
    singleOf(::DbClient)
}