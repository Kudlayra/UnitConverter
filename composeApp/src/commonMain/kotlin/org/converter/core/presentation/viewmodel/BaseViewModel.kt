package org.converter.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import org.converter.core.presentation.UiEvent

abstract class BaseViewModel : ViewModel() {
    val uiEvent = MutableSharedFlow<UiEvent?>()
    abstract fun onEvent(event: UiEvent)
}