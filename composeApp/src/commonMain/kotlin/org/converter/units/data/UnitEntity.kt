package org.converter.units.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.converter.units.domain.UnitModel

@Entity
data class UnitEntity(
    @PrimaryKey
    val name: String,
    @ColumnInfo
    val value: String,
    @ColumnInfo
    val selected: Boolean = false,
    @ColumnInfo
    val type: String,
)

fun UnitEntity.mapToDomain() = UnitModel(name, value, selected, type)

fun UnitModel.mapToEntity() = UnitEntity(name, value, selected, type)