package org.converter.units.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
            .clip(rounded16Shape)
            .background(if (isSelected == true) green else lightGreen)
            .padding(margin16)
            .wrapContentSize()
            .focusClick(onClick = onClick),
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