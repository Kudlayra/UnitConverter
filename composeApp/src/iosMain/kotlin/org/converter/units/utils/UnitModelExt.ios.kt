package org.converter.units.utils

import org.converter.units.domain.CalculatedResultModel
import org.converter.units.domain.UnitModel
import platform.Foundation.*

actual fun UnitModel.convert(unitValue: Double?, inputValue: Double?): CalculatedResultModel {
    val res = inputValue.let { inputDouble ->
        val valueDecimal =
            NSDecimalNumber(inputDouble ?: DOUBLE_EMPTY).decimalNumberByMultiplyingBy(
                NSDecimalNumber(unitValue ?: DOUBLE_EMPTY)
            )
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
    }
    return CalculatedResultModel(res.toString(), getPlural(res))
}