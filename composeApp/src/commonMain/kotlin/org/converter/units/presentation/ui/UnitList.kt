package org.converter.units.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.converter.core.presentation.UiEvent
import org.converter.core.presentation.margin12
import org.converter.core.presentation.margin16
import org.converter.units.domain.UnitModel
import org.converter.units.domain.UnitType
import org.converter.units.presentation.UnitsUiEvent.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UnitList(
    modifier: Modifier = Modifier,
    state: StateFlow<List<UnitModel>?>,
    onEvent: (UiEvent) -> Unit,
) {
    val list by state.collectAsState()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(margin12),
        contentPadding = PaddingValues(vertical = margin16)
    ) {
        items(list.orEmpty()) { unit ->
            Unit(
                name = unit.shortName,
                isSelected = unit.selected
            ) { onEvent(OnUnitClick(unit)) }
        }
    }
}

@Preview
@Composable
private fun PreviewUnitList() {
    UnitList(
        state = MutableStateFlow(
            listOf(
                UnitModel("meter", "m", "meters", "1.0", UnitType.LENGTH),
                UnitModel("kilometer", "km", "kilometers", "1000", UnitType.LENGTH),
            )
        ),
        onEvent = {}
    )
}