package org.converter.units.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitType

@Serializable
data class UnitDto(
    @SerialName("name") val name: String?,
    @SerialName("symbol") val symbol: String?,
    @SerialName("plural") val plural: String?,
    @SerialName("coefficient") val coefficient: String?,
    @SerialName("type") val type: String?,
)

fun UnitDto.mapToDomain() =
    UnitModel(name.orEmpty(), symbol, plural, coefficient, type?.let { enumValueOf<UnitType>(it) })