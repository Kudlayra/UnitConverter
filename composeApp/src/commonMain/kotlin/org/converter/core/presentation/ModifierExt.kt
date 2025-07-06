package org.converter.core.presentation

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun Modifier.focusClick(enabled: Boolean = true, onClick: (() -> Unit)? = null): Modifier {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    val action = if (enabled) onClick else null

    return this then Modifier
        .focusable()
        .indication(interactionSource, lightRipple)
        .pointerInput(Unit) {
            detectTapGestures(
                onPress = { offset: Offset ->
                    focusManager.clearFocus()
                    //индикация клика при нажатии
                    action?.let {
                        val press = PressInteraction.Press(offset)
                        interactionSource.emit(press)
                        tryAwaitRelease()
                        interactionSource.emit(PressInteraction.Release(press))
                    }
                },
                onTap = action?.let { { action() } }
            )
        }
}