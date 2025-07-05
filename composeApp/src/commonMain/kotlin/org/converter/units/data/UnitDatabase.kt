package org.converter.units.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

private const val UNIT_DATABASE_VERSION = 1

@Database(entities = [UnitEntity::class], version = UNIT_DATABASE_VERSION)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class UnitDatabase : RoomDatabase() {
    abstract fun getDao(): UnitDao

    companion object {
        val dbName = "unit.db"
    }
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<UnitDatabase> {
    override fun initialize(): UnitDatabase
}