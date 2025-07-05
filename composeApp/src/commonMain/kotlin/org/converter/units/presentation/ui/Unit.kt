package org.converter.units.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.converter.core.presentation.green
import org.converter.core.presentation.lightGreen
import org.converter.core.presentation.margin8
import org.converter.core.presentation.rounded10Shape
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Unit(
    modifier: Modifier = Modifier,
    name: String?,
    isSelected: Boolean?,
) {

    Box(
        modifier = modifier
            .background(if (isSelected == true) green else lightGreen, shape = rounded10Shape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(margin8),
            text = name.orEmpty()
        )
    }
}

@Preview
@Composable
private fun PreviewUnit() {
    Unit(name = "cm", isSelected = true)
}