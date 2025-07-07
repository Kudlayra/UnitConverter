package org.converter.units.data.remote

import org.converter.units.data.model.UnitDto

interface UnitsRemoteDataSource {
    suspend fun getUnitList(): List<UnitDto>?
}