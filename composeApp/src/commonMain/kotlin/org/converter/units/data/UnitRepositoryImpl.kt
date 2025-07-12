package org.converter.units.data

import kotlinx.coroutines.flow.map
import org.converter.core.utils.safeExecute
import org.converter.units.data.model.mapToDomain
import org.converter.units.data.remote.UnitsRemoteDataSource
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitRepository

class UnitRepositoryImpl(
    private val cache: UnitDao, private val remote: UnitsRemoteDataSource
) : UnitRepository {

    override suspend fun addUnit(unit: UnitModel) {
        safeExecute { cache.insert(unit.mapToEntity()) }
    }

    override suspend fun deleteUnit(unit: UnitModel) {
        safeExecute { cache.delete(unit.mapToEntity()) }
    }

    override suspend fun getUnitListFlow(type: String) =
        cache.getListFlow(type).map { it?.map { unit -> unit.mapToDomain() } }

    override suspend fun setSelectedUnit(unit: UnitModel) {
        safeExecute {
            cache.resetSelection(unit.type?.name.orEmpty())
            cache.setSelectedUnit(unit.mapToEntity().copy(selected = true))
        }
    }

    override suspend fun syncUnitList() {
        safeExecute {
            remote.getUnitList()?.map { it.mapToDomain() }?.also { list ->
                val selectedList = cache.getSelected().orEmpty()
                cache.clear()
                cache.insertList(list.map { unit ->
                    unit.mapToEntity().copy(selected = selectedList.any { it.name == unit.name })
                })
            }
        }
    }
}