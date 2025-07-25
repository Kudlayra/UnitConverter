package org.converter.units.domain

import kotlinx.coroutines.flow.Flow

interface UnitRepository {

    suspend fun addUnit(unit: UnitModel)

    suspend fun deleteUnit(unit: UnitModel)

    suspend fun getUnitListFlow(type: String): Flow<List<UnitModel>?>

    suspend fun setSelectedUnit(unit: UnitModel)

    suspend fun syncUnitList()

    suspend fun getUnit(name: String): UnitModel?

    suspend fun getSelectedByType(type: String?): UnitModel?
}