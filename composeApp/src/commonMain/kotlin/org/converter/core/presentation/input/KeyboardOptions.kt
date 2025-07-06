package org.converter.core.presentation.input

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization

val doneKeyboardOptions = KeyboardOptions.Default.copy(
    imeAction = ImeAction.Done,
    capitalization = KeyboardCapitalization.Sentences
)