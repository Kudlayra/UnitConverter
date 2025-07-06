package org.converter.core.presentation.input

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.converter.units.utils.EMPTY

data class TextInputModel(
    val textState: MutableState<String> = mutableStateOf(EMPTY),
    val interaction: MutableInteractionSource = MutableInteractionSource()
)