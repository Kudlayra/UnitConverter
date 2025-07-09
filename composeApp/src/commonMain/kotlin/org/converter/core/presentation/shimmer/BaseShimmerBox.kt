package org.converter.core.presentation.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.converter.core.presentation.rounded16Shape
import org.converter.core.presentation.shimmerEffect
import org.converter.core.presentation.size56
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BaseShimmerBox(
    modifier: Modifier = Modifier,
    isLoading: Boolean = true,
    shape: RoundedCornerShape = rounded16Shape,
    content: @Composable () -> Unit = {},
) {
    if (isLoading) Box(modifier.shimmerEffect(shape))
    else content()
}

@Preview
@Composable
fun PreviewBaseShimmerBox() {
    BaseShimmerBox(
        modifier = Modifier.size(size56),
        isLoading = true
    )
}