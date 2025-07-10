package org.converter.units.domain

import org.jetbrains.compose.resources.StringResource
import unitconverter.composeapp.generated.resources.Res
import unitconverter.composeapp.generated.resources.length
import unitconverter.composeapp.generated.resources.weight

enum class UnitType(val title: StringResource) {
    WEIGHT(Res.string.weight), LENGTH(Res.string.length)
}