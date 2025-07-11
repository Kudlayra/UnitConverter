package org.converter.units.utils

import org.converter.units.domain.UnitModel
import platform.Foundation.*

actual fun UnitModel.convert(inputValue: String): Double {
    return inputValue.toDoubleOrNull()?.let { inputDouble ->
        val valueDecimal = NSDecimalNumber(inputDouble)
        val unitDecimal = NSDecimalNumber(value)

        val behavior = NSDecimalNumberHandler(
            roundingMode = NSRoundingMode.NSRoundDown,
            scale = SCALE,
            raiseOnExactness = false,
            raiseOnOverflow = false,
            raiseOnUnderflow = false,
            raiseOnDivideByZero = false
        )

        valueDecimal.decimalNumberByDividingBy(unitDecimal, behavior).doubleValue
    } ?: DOUBLE_EMPTY
}