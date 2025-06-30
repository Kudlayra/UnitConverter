package org.converter.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Unit(
    name: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {

    Box(modifier = modifier) {
        Text(
            text = name,

        )
    }

}

@Preview
@Composable
private fun PreviewUnit() {
    Unit(name = "cm", isSelected = true)
}