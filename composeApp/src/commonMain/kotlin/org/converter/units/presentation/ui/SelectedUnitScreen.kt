package org.converter.units.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import org.converter.core.presentation.darkGreen
import org.converter.core.presentation.input.BaseTextInput
import org.converter.core.presentation.margin12
import org.converter.core.presentation.margin16
import org.converter.units.presentation.UnitsUiEvent
import org.converter.units.utils.DOT
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import unitconverter.composeapp.generated.resources.Res
import unitconverter.composeapp.generated.resources.enter_a_value
import unitconverter.composeapp.generated.resources.zero_placeholder

@Composable
fun SelectedUnitScreen(vm: SelectedUnitViewModel = koinViewModel()) {
    val sourceUnit by vm.sourceUnit.collectAsState()
    val convertedUnit by vm.convertedUnit.collectAsState()
    Scaffold(
        content = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(darkGreen)
                    .padding(horizontal = margin16),
                horizontalArrangement = Arrangement.spacedBy(margin16)
            ) {
                Unit(
                    modifier = Modifier.padding(top = margin16),
                    name = sourceUnit?.shortName,
                    isSelected = true
                )
                Column(verticalArrangement = Arrangement.spacedBy(margin12)) {
                    BaseTextInput(
                        state = vm.inputState,
                        label = stringResource(Res.string.enter_a_value),
                        placeholder = stringResource(Res.string.zero_placeholder),
                        keyboardType = KeyboardType.Decimal,
                        onValueChange = { text ->
                            vm.inputState.textState.value =
                                text.filter { it.isDigit() || it == DOT }
                            vm.onEvent(UnitsUiEvent.OnInputValueChanged)
                        }
                    )
                    CalculatedUnit(
                        amount = convertedUnit?.value.orEmpty(),
                        name = convertedUnit?.name.orEmpty()
                    )
                }
            }
        }
    )
}