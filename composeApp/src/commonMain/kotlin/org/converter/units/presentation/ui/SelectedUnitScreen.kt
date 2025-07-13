package org.converter.units.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import org.converter.core.presentation.input.BaseTextInput
import org.converter.units.presentation.UnitsUiEvent
import org.converter.units.utils.DOT
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import unitconverter.composeapp.generated.resources.Res
import unitconverter.composeapp.generated.resources.enter_a_value
import unitconverter.composeapp.generated.resources.zero_placeholder

@Composable
fun SelectedUnitScreen(vm: SelectedUnitViewModel = koinViewModel()) {
    Scaffold(
        content = {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                BaseTextInput(
                    state = vm.inputState,
                    label = stringResource(Res.string.enter_a_value),
                    placeholder = stringResource(Res.string.zero_placeholder),
                    keyboardType = KeyboardType.Decimal,
                    onValueChange = { text ->
                        vm.inputState.textState.value = text.filter { it.isDigit() || it == DOT }
                        vm.onEvent(UnitsUiEvent.OnInputValueChanged)
                    }
                )
                CalculatedUnit(
                    amount = "",
                    name = ""
                )
            }
        }
    )
}