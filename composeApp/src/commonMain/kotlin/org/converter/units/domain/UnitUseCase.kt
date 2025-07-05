package org.converter.units.domain

class UnitUseCase(private val repository: UnitRepository) {

    suspend fun addUnit(unit: UnitModel) = repository.addUnit(unit)

    suspend fun deleteUnit(unit: UnitModel) = repository.deleteUnit(unit)

    suspend fun getUnitList(type: String) = repository.getUnitList(type)
}