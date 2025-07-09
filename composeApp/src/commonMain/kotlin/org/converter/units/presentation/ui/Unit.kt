package org.converter.units.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import org.converter.core.presentation.focusClick
import org.converter.core.presentation.green
import org.converter.core.presentation.lightGreen
import org.converter.core.presentation.margin16
import org.converter.core.presentation.rounded16Shape
import org.converter.core.presentation.size56
import org.converter.core.presentation.text18BoldStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Unit(
    modifier: Modifier = Modifier,
    name: String?,
    isSelected: Boolean?,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier
            .size(size56)
            .clip(rounded16Shape)
            .focusClick(onClick = onClick)
            .background(if (isSelected == true) green else lightGreen)
            .padding(margin16),
        style = text18BoldStyle,
        text = name.orEmpty(),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun PreviewUnit() {
    Unit(name = "cm", isSelected = true) {}
}