package com.example.core.ui

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.compose.foundation.isSystemInDarkTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun StatusBarColor(color: Color, darkTheme: Boolean = isSystemInDarkTheme()) {
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            view.context?.let { context ->
                if (context is Activity) {
                    context.window.statusBarColor = color.toArgb()

                    val windowInsetsController = WindowCompat.getInsetsController(context.window, view)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        // Use WindowInsetsController directly for API 30 and above
                        windowInsetsController.isAppearanceLightStatusBars = !darkTheme
                        windowInsetsController.isAppearanceLightNavigationBars = !darkTheme
                    } else {
                        // Use deprecated method for older versions
                        @Suppress("DEPRECATION")
                        context.window.decorView.systemUiVisibility = if (darkTheme) {
                            context.window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                        } else {
                            context.window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        }
                    }
                }
            }
        }
    }
}