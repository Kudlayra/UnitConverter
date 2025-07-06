package org.converter

import android.app.Application
import org.converter.di.initKoin
import org.koin.android.ext.koin.androidContext

class UnitConverterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin { androidContext(this@UnitConverterApp) }
    }
}