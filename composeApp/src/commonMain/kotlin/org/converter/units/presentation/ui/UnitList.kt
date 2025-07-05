package org.converter.units.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.converter.core.presentation.margin12
import org.converter.units.domain.UnitModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UnitList(
    modifier: Modifier = Modifier,
    list: List<UnitModel>,
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(margin12)
    ) {
        items(list) {
            Unit(
                name = it.name,
                isSelected = it.selected
            )
        }
    }
}

@Preview
@Composable
private fun PreviewUnitList() {
    UnitList(
        list = listOf(
            UnitModel(name = "cm", selected = true, type = "Length", value = ""),
            UnitModel(name = "m", selected = false, type = "Length", value = ""),
            UnitModel(name = "km", selected = false, type = "Length", value = "")
        )
    )
}