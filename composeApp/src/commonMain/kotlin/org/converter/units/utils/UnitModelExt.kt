package org.converter.units.utils

import org.converter.units.domain.CalculatedResultModel
import org.converter.units.domain.UnitModel

const val SCALE: Short = 10

expect fun UnitModel.convert(inputValue: String): Double

fun UnitModel.getPlural(value: Double): CalculatedResultModel {
    val unitName = when (value) {
        DOUBLE_EMPTY, DOUBLE_ONE -> name
        else -> pluralName
    }.orEmpty()
    return CalculatedResultModel(value.toString(), unitName)
}