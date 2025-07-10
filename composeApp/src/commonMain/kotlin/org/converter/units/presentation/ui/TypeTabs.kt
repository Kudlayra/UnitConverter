package org.converter.units.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.converter.core.presentation.UiEvent
import org.converter.core.presentation.darkGreen
import org.converter.core.presentation.focusClick
import org.converter.core.presentation.green
import org.converter.core.presentation.margin12
import org.converter.core.presentation.margin8
import org.converter.core.presentation.rounded16Shape
import org.converter.core.presentation.text18BoldStyle
import org.converter.core.presentation.text18WhiteBoldStyle
import org.converter.units.domain.UnitType
import org.converter.units.presentation.UnitsUiEvent.*
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeTabs(
    modifier: Modifier = Modifier,
    tabState: StateFlow<UnitType>,
    onEvent: (UiEvent) -> Unit,
) {
    val selectedTab by tabState.collectAsState()

    SecondaryTabRow(
        modifier = modifier.padding(margin12),
        containerColor = darkGreen,
        selectedTabIndex = UnitType.entries.indexOf(selectedTab),
        divider = {},
        indicator = {},
    ) {
        UnitType.entries.forEach { type ->
            Text(
                modifier = Modifier
                    .clip(rounded16Shape)
                    .background(if (type == selectedTab) green else darkGreen)
                    .focusClick { onEvent(OnSelectType(type)) }
                    .padding(vertical = margin8, horizontal = margin12),
                text = stringResource(type.title),
                style = if (type == selectedTab) text18WhiteBoldStyle else text18BoldStyle,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun PreviewTypeTabs() {
    TypeTabs(tabState = MutableStateFlow(UnitType.WEIGHT)) {}
}