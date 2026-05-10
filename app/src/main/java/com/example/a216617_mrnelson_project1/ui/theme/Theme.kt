package com.example.a216617_mrnelson_project1.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = TrustBluePrimary,
    onPrimary = Color.White,
    secondary = LoyaltyBlueSecondary,
    onSecondary = Color.White,
    background = Color.Black, // Explicitly black
    surface = Color(0xFF121212), // Dark surface for cards
    onBackground = Color.White,
    surfaceContainerLow = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = TrustBluePrimary,
    onPrimary = Color.White,
    secondary = LoyaltyBlueSecondary,
    onSecondary = Color.White,
    background = PeacefulBlueBg,
    surface = Color.White,
    surfaceContainerLow = Color.Black,
    error = Color(0xFFD32F2F)

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun A216617_MrNelson_Project1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}