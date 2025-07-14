package org.converter.units.presentation.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.converter.core.presentation.UiEvent
import org.converter.core.presentation.input.TextInputModel
import org.converter.core.presentation.viewmodel.BaseViewModel
import org.converter.units.domain.CalculatedResultModel
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitUseCase
import org.converter.units.presentation.UnitsUiEvent
import org.converter.units.utils.convert

class SelectedUnitViewModel(name: String, private val unitUseCase: UnitUseCase) : BaseViewModel() {

    val inputState = TextInputModel()

    private val _sourceUnit = MutableStateFlow<UnitModel?>(null)
    val sourceUnit = _sourceUnit.asStateFlow()

    private val _targetUnit = MutableStateFlow<UnitModel?>(null)
    val targetUnit = _targetUnit.asStateFlow()

    private val _convertedUnit = MutableStateFlow<CalculatedResultModel?>(null)
    val convertedUnit = _convertedUnit.asStateFlow()

    init {
        viewModelScope.launch {
            _targetUnit.value = unitUseCase.getUnit(name).also {
                _sourceUnit.value = unitUseCase.getSelectedByType(it?.type?.name)
            }
        }
    }

    override fun onEvent(event: UiEvent) {
        when (event) {
            is UnitsUiEvent.OnInputValueChanged -> updateConvertedList()
        }
    }

    private fun updateConvertedList() {
        _convertedUnit.value = targetUnit.value?.convert(
            _sourceUnit.value?.value?.toDoubleOrNull(),
            inputState.textState.value.toDoubleOrNull()
        )
    }
}