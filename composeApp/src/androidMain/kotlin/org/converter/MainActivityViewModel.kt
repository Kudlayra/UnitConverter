package org.converter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.converter.units.domain.UnitUseCase

class MainActivityViewModel(private val unitUseCase: UnitUseCase): ViewModel() {

    init {
        viewModelScope.launch {
            unitUseCase.syncUnitList()
        }
    }
}