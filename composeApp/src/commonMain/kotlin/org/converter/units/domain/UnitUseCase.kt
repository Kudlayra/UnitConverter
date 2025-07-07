package org.converter.units.domain

class UnitUseCase(private val repository: UnitRepository) {

    suspend fun setUnitList(list: List<UnitModel>) = repository.setUnitList(list)

    suspend fun setSelectedUnit(unit: UnitModel) = repository.setSelectedUnit(unit)

    suspend fun addUnit(unit: UnitModel) = repository.addUnit(unit)

    suspend fun deleteUnit(unit: UnitModel) = repository.deleteUnit(unit)

    suspend fun getUnitListFlow(type: String) = repository.getUnitListFlow(type)

    suspend fun syncUnitList() = repository.syncUnitList()
}