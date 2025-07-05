package org.converter.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.converter.units.data.UnitRepositoryImpl
import org.converter.units.data.database.DatabaseFactory
import org.converter.units.domain.UnitRepository
import org.converter.units.domain.UnitUseCase
import org.koin.dsl.module

val sharedModule = module {
    single<UnitRepository> { UnitRepositoryImpl(get()) }
    single<UnitUseCase> { UnitUseCase(get()) }
    single {
        get<DatabaseFactory>()
            .getDatabaseBuilder()
            .setDriver(BundledSQLiteDriver())
            .fallbackToDestructiveMigration(true)
            .build()

    }
}