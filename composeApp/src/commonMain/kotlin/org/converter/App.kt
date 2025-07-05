package org.converter

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.converter.units.presentation.ui.UnitsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        UnitsScreen()
    }
}