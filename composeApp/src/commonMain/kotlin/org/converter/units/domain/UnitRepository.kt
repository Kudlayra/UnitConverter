package org.converter.units.domain

import kotlinx.coroutines.flow.Flow

interface UnitRepository {

    suspend fun addUnit(unit: UnitModel)

    suspend fun deleteUnit(unit: UnitModel)

    suspend fun getUnitList(type: String): Flow<List<UnitModel>>
}