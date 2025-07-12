package org.converter.core.presentation.lazylist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.StateFlow
import org.converter.core.presentation.black
import org.converter.core.presentation.zero

@Composable
fun <T> DecoratedLazyColumn(
    modifier: Modifier = Modifier,
    list: StateFlow<List<T>?>,
    listState: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(zero),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    decorator: @Composable () -> Unit = { HorizontalDivider(color = black) },
    item: @Composable (T) -> Unit
) {
    val list by list.collectAsState()
    list?.let {
        LazyColumn(
            state = listState,
            modifier = modifier,
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement
        ) {
            itemsIndexed(it) { index, item ->
                item(item)
                if (it.size.dec() > index) decorator()
            }
        }
    }

}