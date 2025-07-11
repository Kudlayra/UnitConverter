package org.converter.units.utils

import org.converter.units.domain.UnitModel
import java.math.BigDecimal
import java.math.RoundingMode

actual fun UnitModel.convert(inputValue: String): Double {
    return BigDecimal(value.toString()).divide(
        BigDecimal(value),
        SCALE.toInt(),
        RoundingMode.DOWN
    ).toDouble()
}