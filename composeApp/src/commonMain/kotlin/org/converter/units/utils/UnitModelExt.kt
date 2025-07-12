package org.converter.units.utils

import org.converter.units.domain.CalculatedResultModel
import org.converter.units.domain.UnitModel

const val SCALE: Short = 10

expect fun UnitModel.convert(unitValue: Double?, inputValue: Double?): CalculatedResultModel

fun UnitModel.getPlural(value: Double): String {
    return when (value) {
        DOUBLE_EMPTY, DOUBLE_ONE -> name
        else -> pluralName
    }.orEmpty()
}

fun List<UnitModel>.mapToCalculatedList(inputValue: String): List<CalculatedResultModel> {
    val selected = find { unit -> unit.selected }?.value?.toDoubleOrNull()
    return map { it.convert(selected, inputValue.toDoubleOrNull()) }
}