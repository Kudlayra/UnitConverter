package org.converter.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.converter.units.presentation.ui.UnitsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        Scaffold(
            content = { innerPadding ->
                NavHost(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    startDestination = Route.UnitsScreen
                ) {
                    composable<Route.UnitsScreen> {
                        UnitsScreen()
                    }
                }
            }
        )
    }
}