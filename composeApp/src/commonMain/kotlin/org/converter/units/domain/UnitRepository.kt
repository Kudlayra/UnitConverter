package org.converter.units.domain

import kotlinx.coroutines.flow.Flow

interface UnitRepository {

    suspend fun addUnit(unit: UnitModel): Boolean

    suspend fun deleteUnit(unit: UnitModel): Boolean

    suspend fun getUnitList(type: String): Flow<List<UnitModel>>
}