package org.converter.units.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import org.converter.core.presentation.UiEvent
import org.converter.core.presentation.input.TextInputModel
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitType
import org.converter.units.domain.UnitUseCase

@OptIn(ExperimentalCoroutinesApi::class)
class UnitsViewModel(private val unitUseCase: UnitUseCase) : ViewModel() {

    val inputState = TextInputModel()

    val selectedType = MutableStateFlow(UnitType.WEIGHT)

    private val _unitList = MutableStateFlow<List<UnitModel>?>(null)
    val unitList = _unitList.asStateFlow()

    private val uiEvent = Channel<UiEvent?>()

    init {
        viewModelScope.launch { unitUseCase.syncUnitList() }

        viewModelScope.launch {
            selectedType.flatMapLatest { unitUseCase.getUnitListFlow(selectedType.value.name) }
                .collect { _unitList.value = it }
        }
    }

    fun onEvent(event: UiEvent) {
        uiEvent.trySend(event)
        when (event) {
            is UnitsUiEvent.OnUnitClick -> setSelectedUnit(event.unit)
            is UnitsUiEvent.OnSelectType -> selectedType.value = event.type
        }
    }

    private fun setSelectedUnit(unit: UnitModel) {
        viewModelScope.launch {
            unitUseCase.setSelectedUnit(unit)
        }
    }
}