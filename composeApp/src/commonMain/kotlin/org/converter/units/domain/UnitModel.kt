package org.converter.units.domain

data class UnitModel(
    val name: String,
    val value: String,
    val selected: Boolean = false,
    val type: String,
)