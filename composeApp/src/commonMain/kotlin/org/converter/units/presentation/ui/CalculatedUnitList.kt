package org.converter.units.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.converter.core.presentation.UiEvent
import org.converter.core.presentation.black
import org.converter.core.presentation.lazylist.DecoratedLazyColumn
import org.converter.core.presentation.margin12
import org.converter.core.presentation.margin16
import org.converter.units.domain.CalculatedResultModel
import org.converter.units.presentation.UnitsUiEvent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CalculatedUnitList(
    modifier: Modifier = Modifier,
    listState: StateFlow<List<CalculatedResultModel>?>,
    onEvent: (UiEvent) -> Unit,
) {
    DecoratedLazyColumn(
        modifier = modifier,
        list = listState,
        contentPadding = PaddingValues(vertical = margin16),
        decorator = {
            HorizontalDivider(
                modifier = Modifier.padding(vertical = margin12),
                color = black
            )
        }
    ) {
        CalculatedUnit(
            amount = it.value,
            name = it.name
        ) { onEvent(UnitsUiEvent.OnCalculatedUnitClick) }
    }
}

@Preview
@Composable
private fun PreviewCalculatedUnitList() {
    CalculatedUnitList(
        listState = MutableStateFlow(listOf(CalculatedResultModel("1", "kilogram")))
    ) {}
}