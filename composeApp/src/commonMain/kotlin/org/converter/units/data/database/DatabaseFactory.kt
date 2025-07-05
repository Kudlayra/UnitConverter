package org.converter.units.data.database

import androidx.room.RoomDatabase
import org.converter.units.data.UnitDatabase

expect class DatabaseFactory {
    fun getDatabaseBuilder(): RoomDatabase.Builder<UnitDatabase>
}