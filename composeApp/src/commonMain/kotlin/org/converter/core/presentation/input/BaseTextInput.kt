package org.converter.core.presentation.input

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BaseTextInput(
    modifier: Modifier = Modifier,
    state: TextInputModel,
    label: String? = null,
    onValueChange: ((String) -> Unit)? = null,
) {
    TextField(
        modifier = modifier,
        value = state.textState.value,
        onValueChange = {
            state.textState.value = it
            onValueChange?.invoke(it)
        },
        interactionSource = state.interaction,
        label = label?.let { { Text(text = it) } }
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