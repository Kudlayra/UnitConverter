package org.converter.units.presentation.ui

import org.converter.core.presentation.UiEvent
import org.converter.core.presentation.input.TextInputModel
import org.converter.core.presentation.viewmodel.BaseViewModel
import org.converter.units.domain.UnitUseCase

class SelectedUnitViewModel(private val unitUseCase: UnitUseCase) : BaseViewModel() {
    val inputState = TextInputModel()

    override fun onEvent(event: UiEvent) {

    }
}