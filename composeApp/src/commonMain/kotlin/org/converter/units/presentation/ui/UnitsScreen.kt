package org.converter.units.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import org.converter.core.presentation.input.BaseTextInput
import org.converter.core.presentation.input.TextInputModel

@Composable
fun UnitsScreen() {
    Scaffold {
        Row {
            UnitList(
                list = emptyList()
            )

            BaseTextInput(
                state = TextInputModel()
            )
        }
    }
}