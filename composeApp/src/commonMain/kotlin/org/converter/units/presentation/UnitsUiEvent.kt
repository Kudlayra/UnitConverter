package org.converter.units.presentation

import org.converter.core.presentation.UiEvent
import org.converter.units.domain.UnitModel

sealed interface UnitsUiEvent: UiEvent {
    data class OnUnitClick(val unit: UnitModel) : UnitsUiEvent
}