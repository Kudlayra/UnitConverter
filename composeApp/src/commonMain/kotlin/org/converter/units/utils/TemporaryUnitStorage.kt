package org.converter.units.utils

import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitType.*

object TemporaryUnitStorage {
    val units = listOf(
        UnitModel("meter", "m", "meters", "1.0", LENGTH),
        UnitModel("kilometer", "km", "kilometers", "1000", LENGTH),
        UnitModel("centimeter", "cm", "centimeters", "0.01", LENGTH),
        UnitModel("millimeter", "mm", "millimeters", "0.001", LENGTH),
        UnitModel("mile", "mi", "miles", "1609.35", LENGTH),
        UnitModel("foot", "ft", "feet", "0.3048", LENGTH),
        UnitModel("inch", "in", "inches", "0.0254", LENGTH),
        UnitModel("yard", "yd", "yards", "0.9144", LENGTH),

        UnitModel("kilogram", "kg", "kilograms", "1000", WEIGHT),
        UnitModel("milligram", "mg", "milligrams", "0.001", WEIGHT),
        UnitModel("pound", "lb", "pounds", "453.592", WEIGHT),
        UnitModel("ounce", "oz", "ounces", "28.3495", WEIGHT),
        UnitModel("centner", "c", "centners", "100000", WEIGHT),
        UnitModel("gram", "g", "grams", "1", WEIGHT),
        UnitModel("ton", "t", "tons", "1000000", WEIGHT),
        UnitModel("carat", "ct", "carats", "0.2", WEIGHT),
        UnitModel("newton", "N", "newtons", "101.97162129779", WEIGHT),
        UnitModel("stone", "st", "stones", "6350.29318", WEIGHT),
        UnitModel("dram", "dr", "drams", "1.7718451953125", WEIGHT),
        UnitModel("gran", "gr", "grains", "0.0647989", WEIGHT)
    )
}