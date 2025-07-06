package org.converter.core.presentation.input

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import org.converter.core.presentation.rounded16Shape
import org.converter.core.presentation.text34style
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BaseTextInput(
    modifier: Modifier = Modifier,
    state: TextInputModel,
    textStyle: TextStyle = text34style,
    label: String? = null,
    placeholder: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    colors: TextFieldColors = greenInputStyle,
    onValueChange: (String) -> Unit = { state.textState.value = it },
) {
    val softInputController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        textStyle = textStyle,
        modifier = modifier,
        value = state.textState.value,
        onValueChange = onValueChange,
        interactionSource = state.interaction,
        label = label?.let { { Text(text = it) } },
        placeholder = placeholder?.let {
            {
                Text(
                    text = it,
                    style = text34style,
                    textAlign = TextAlign.Center
                )
            }
        },
        colors = colors,
        keyboardOptions = doneKeyboardOptions.copy(keyboardType = keyboardType),
        keyboardActions = KeyboardActions(
            onDone = { softInputController?.hide() }
        ),
        shape = rounded16Shape
    )
}

@Preview
@Composable
private fun PreviewBaseTextInput() {
    BaseTextInput(
        state = TextInputModel(textState = mutableStateOf("1234")),
        label = "Введите значение"
    )
}