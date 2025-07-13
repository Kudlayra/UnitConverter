package org.converter

import androidx.compose.ui.window.ComposeUIViewController
import org.converter.app.App
import org.converter.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }