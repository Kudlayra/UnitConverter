package org.converter.units.presentation

import org.converter.core.presentation.UiEvent
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitType

sealed interface UnitsUiEvent : UiEvent {
    data class OnUnitClick(val unit: UnitModel) : UnitsUiEvent
    data class OnSelectType(val type: UnitType) : UnitsUiEvent
    data object OnInputValueChanged : UnitsUiEvent
    data class OnCalculatedUnitClick(val name: String) : UnitsUiEvent
}