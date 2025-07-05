package org.converter.units.data

import kotlinx.coroutines.flow.map
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitRepository

class UnitRepositoryImpl(private val cache: UnitDao) : UnitRepository {
    override suspend fun addUnit(unit: UnitModel) = cache.insert(unit.mapToEntity())

    override suspend fun deleteUnit(unit: UnitModel) = cache.delete(unit.mapToEntity())

    override suspend fun getUnitList(type: String) =
        cache.getList(type).map { it.map { unit -> unit.mapToDomain() } }
}