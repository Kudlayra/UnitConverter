package org.converter.units.utils

import org.converter.units.domain.CalculatedResultModel
import org.converter.units.domain.UnitModel
import java.math.BigDecimal
import java.math.RoundingMode

actual fun UnitModel.convert(unitValue: Double?, inputValue: Double?): CalculatedResultModel {
    val amount =
        BigDecimal(unitValue ?: DOUBLE_EMPTY).multiply(BigDecimal(inputValue ?: DOUBLE_EMPTY))
    val res =
        amount.divide(BigDecimal(value), RoundingMode.DOWN).stripTrailingZeros().toPlainString()
    return CalculatedResultModel(res, getPlural(res.toDouble()))
}