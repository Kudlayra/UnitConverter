package org.converter.core.presentation

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.IntSize

private const val GRADIENT_DURATION = 1500

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

@Composable
fun Modifier.shimmerEffect(
    shape: Shape
): Modifier {
    var size by remember { mutableStateOf(IntSize.Zero) }

    val transition = rememberInfiniteTransition()

    val startOffsetX by transition.animateFloat(
        initialValue = -size.width.toFloat() / 2,
        targetValue = size.width.toFloat() / 2,
        animationSpec = infiniteRepeatable(tween(GRADIENT_DURATION), RepeatMode.Reverse),
    )

    return background(
        shape = shape,
        brush = Brush.horizontalGradient(
            colors = listOf(lightGreen, green),
            startX = startOffsetX,
            endX = startOffsetX + size.width
        )
    ).onGloballyPositioned { size = it.size }
}