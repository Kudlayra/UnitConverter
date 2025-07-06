package org.converter.core.presentation.input

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import org.converter.core.presentation.black
import org.converter.core.presentation.white

val greenInputStyle
    @Composable get() = OutlinedTextFieldDefaults.colors(
        focusedLabelColor = black,
        unfocusedLabelColor = black,
        cursorColor = black,
        focusedBorderColor = black,
        unfocusedBorderColor = black,
        focusedPlaceholderColor = black,
        focusedTextColor = white,
        unfocusedTextColor = white
    )