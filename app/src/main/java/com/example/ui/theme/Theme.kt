package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = IosBlue,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF1A3B66),
    onPrimaryContainer = Color(0xFFD6E4FF),
    secondary = IosIndigo,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF2B2857),
    onSecondaryContainer = Color(0xFFE2DFFF),
    tertiary = IosPink,
    onTertiary = Color.White,
    background = IosDarkBackground,
    onBackground = IosDarkTextPrimary,
    surface = IosDarkSurface,
    onSurface = IosDarkTextPrimary,
    surfaceVariant = IosDarkSurfaceElevated,
    onSurfaceVariant = IosDarkTextSecondary,
    outline = IosDarkBorder
)

private val LightColorScheme = lightColorScheme(
    primary = IosBlue,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD6E4FF),
    onPrimaryContainer = Color(0xFF001B3D),
    secondary = IosIndigo,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFE2DFFF),
    onSecondaryContainer = Color(0xFF151042),
    tertiary = IosPink,
    onTertiary = Color.White,
    background = IosLightBackground,
    onBackground = IosLightTextPrimary,
    surface = IosLightSurface,
    onSurface = IosLightTextPrimary,
    surfaceVariant = IosLightSurfaceElevated,
    onSurfaceVariant = IosLightTextSecondary,
    outline = IosLightBorder
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
