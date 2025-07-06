package org.converter.units.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitType

@Entity
data class UnitEntity(
    @PrimaryKey
    val name: String,
    @ColumnInfo
    val shortName: String,
    @ColumnInfo
    val pluralName: String,
    @ColumnInfo
    val value: String,
    @ColumnInfo
    val type: String,
    @ColumnInfo
    val selected: Boolean = false,
)

fun UnitEntity.mapToDomain() =
    UnitModel(name, shortName, pluralName, value, enumValueOf<UnitType>(type), selected)

fun UnitModel.mapToEntity() = UnitEntity(name, shortName, pluralName, value, type.name, selected)