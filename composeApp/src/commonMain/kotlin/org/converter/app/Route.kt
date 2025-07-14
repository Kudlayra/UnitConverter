package org.converter.app

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object UnitsScreen : Route

    @Serializable
    data class SelectedUnitScreen(val name: String) : Route
}