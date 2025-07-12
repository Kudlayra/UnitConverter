package org.converter.units.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.converter.core.presentation.margin4
import org.converter.core.presentation.text14GreenBoldStyle
import org.converter.core.presentation.text14LightGreenBoldStyle
import org.converter.units.utils.FLOAT_ONE
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CalculatedUnit(
    modifier: Modifier = Modifier,
    amount: String,
    name: String
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(margin4)
    ) {
        Text(
            modifier = Modifier.weight(weight = FLOAT_ONE, fill = false),
            text = amount,
            style = text14LightGreenBoldStyle
        )
        Text(
            modifier = Modifier.wrapContentSize(unbounded = true),
            text = name,
            style = text14GreenBoldStyle
        )
    }
}

@Preview
@Composable
private fun PreviewCalculatedUnit() {
    CalculatedUnit(amount = "1", name = "kilogram")
}