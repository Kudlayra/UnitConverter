package org.converter.units.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(unit: UnitEntity)

    @Upsert
    suspend fun update(unit: UnitEntity)

    @Delete
    suspend fun delete(unit: UnitEntity)

    @Query("SELECT * FROM UnitEntity WHERE selected = 1 LIMIT 1")
    suspend fun getSelected(): UnitEntity?

    @Query("SELECT * FROM UnitEntity WHERE type = :type")
    fun getListFlow(type: String): Flow<List<UnitEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(map: List<UnitEntity>)

    @Query("DELETE FROM UnitEntity")
    suspend fun clear()

    @Query("UPDATE UnitEntity SET selected = 0")
    suspend fun resetSelection()

    @Upsert
    suspend fun setSelectedUnit(mapToEntity: UnitEntity)
}