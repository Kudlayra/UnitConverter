package org.converter.units.domain

data class UnitModel(
    val name: String,
    val shortName: String?,
    val pluralName: String?,
    val value: String?,
    val type: UnitType?,
    val selected: Boolean = false,
)