package org.converter

import android.app.Application
import org.converter.di.initKoin

class UnitConverterApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}