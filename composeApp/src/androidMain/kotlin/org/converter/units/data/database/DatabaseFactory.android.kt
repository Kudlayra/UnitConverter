package org.converter.units.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.converter.units.data.UnitDatabase
import org.converter.units.data.UnitDatabase.Companion.dbName

actual class DatabaseFactory(private val context: Context) {
    actual fun getDatabaseBuilder(): RoomDatabase.Builder<UnitDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(dbName)
        return Room.databaseBuilder<UnitDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}