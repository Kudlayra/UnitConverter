package org.converter.units.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import org.converter.core.presentation.UiEvent
import org.converter.core.presentation.input.TextInputModel
import org.converter.core.presentation.viewmodel.BaseViewModel
import org.converter.units.domain.CalculatedResultModel
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitType
import org.converter.units.domain.UnitUseCase
import org.converter.units.utils.mapToCalculatedList

@OptIn(ExperimentalCoroutinesApi::class)
class UnitsViewModel(private val unitUseCase: UnitUseCase) : BaseViewModel() {

    val inputState = TextInputModel()

    val selectedType = MutableStateFlow(UnitType.WEIGHT)

    private val _unitList = MutableStateFlow<List<UnitModel>?>(null)
    val unitList = _unitList.asStateFlow()

    private val _convertedList = MutableStateFlow<List<CalculatedResultModel>?>(null)
    val convertedList = _convertedList.asStateFlow()

    init {
        viewModelScope.launch { unitUseCase.syncUnitList() }

        viewModelScope.launch {
            selectedType.flatMapLatest { unitUseCase.getUnitListFlow(selectedType.value.name) }
                .collect {
                    _unitList.value = it
                    updateConvertedList()
                }
        }
    }

    override fun onEvent(event: UiEvent) {
        viewModelScope.launch { uiEvent.emit(event) }
        when (event) {
            is UnitsUiEvent.OnUnitClick -> setSelectedUnit(event.unit)
            is UnitsUiEvent.OnSelectType -> selectedType.value = event.type
            is UnitsUiEvent.OnInputValueChanged -> updateConvertedList()
        }
    }

    private fun setSelectedUnit(unit: UnitModel) {
        viewModelScope.launch { unitUseCase.setSelectedUnit(unit) }
    }

    private fun updateConvertedList() {
        _convertedList.value = _unitList.value?.mapToCalculatedList(inputState.textState.value)
    }
}