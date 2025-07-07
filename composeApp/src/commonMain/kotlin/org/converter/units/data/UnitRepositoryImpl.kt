package org.converter.units.data

import kotlinx.coroutines.flow.map
import org.converter.core.utils.execute
import org.converter.units.data.model.mapToDomain
import org.converter.units.data.remote.UnitsRemoteDataSource
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitRepository

class UnitRepositoryImpl(
    private val cache: UnitDao, private val remote: UnitsRemoteDataSource
) : UnitRepository {
    override suspend fun setUnitList(list: List<UnitModel>) {
        execute {
            val selectedUnit = cache.getSelected()
            cache.clear()
            cache.insertList(
                list.map { it.mapToEntity().copy(selected = it.name == selectedUnit?.name) }
            )
        }
    }

    override suspend fun addUnit(unit: UnitModel) {
        execute { cache.insert(unit.mapToEntity()) }
    }

    override suspend fun deleteUnit(unit: UnitModel) {
        execute { cache.delete(unit.mapToEntity()) }
    }

    override suspend fun getUnitListFlow(type: String) =
        cache.getListFlow(type).map { it.map { unit -> unit.mapToDomain() } }

    override suspend fun setSelectedUnit(unit: UnitModel) {
        execute {
            cache.resetSelection()
            cache.setSelectedUnit(unit.mapToEntity().copy(selected = true))
        }
    }

    override suspend fun syncUnitList() {
        execute {
            val list = remote.getUnitList()
            list?.let { setUnitList(it.map { unit -> unit.mapToDomain() }) }
        }
    }
}