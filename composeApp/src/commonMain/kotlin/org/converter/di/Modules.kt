package org.converter.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.converter.units.data.UnitDao
import org.converter.units.data.UnitDatabase
import org.converter.units.data.UnitRepositoryImpl
import org.converter.units.data.database.DatabaseFactory
import org.converter.units.domain.UnitRepository
import org.converter.units.domain.UnitUseCase
import org.converter.units.presentation.UnitsViewModel
import org.converter.units.utils.TemporaryUnitStorage
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single<UnitRepository> { UnitRepositoryImpl(get()) }
    single<UnitUseCase> { UnitUseCase(get()) }
    single<UnitDao> { get<UnitDatabase>().getDao() }
    single {
        get<DatabaseFactory>()
            .getDatabaseBuilder()
            .setDriver(BundledSQLiteDriver())
            .fallbackToDestructiveMigration(true)
            .build()

    }
    single { TemporaryUnitStorage }
    viewModelOf(::UnitsViewModel)
}