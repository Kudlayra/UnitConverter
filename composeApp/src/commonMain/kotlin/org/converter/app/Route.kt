package org.converter.app

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object UnitsScreen: Route
    @Serializable
    data object SelectedUnitScreen: Route
}