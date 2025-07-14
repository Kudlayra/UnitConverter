package org.converter.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.converter.core.presentation.darkGreen
import org.converter.core.presentation.focusClick
import org.converter.units.presentation.ui.SelectedUnitScreen
import org.converter.units.presentation.ui.UnitsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            modifier = Modifier
                .background(darkGreen)
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .focusClick(),
            navController = navController,
            startDestination = Route.UnitsScreen
        ) {
            composable<Route.UnitsScreen> {
                UnitsScreen { navController.navigate(it) }
            }
            composable<Route.SelectedUnitScreen> {
                SelectedUnitScreen()
            }
        }
    }
}