package com.uuthman.movieapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = BlackColor,
    primaryVariant = WhiteColor,
    background = BlackColor,
    onPrimary = WhiteColor,
    onBackground = WhiteColor

)

private val LightColorPalette = lightColors(
    primary = BlackColor,
    primaryVariant = WhiteColor,
    background = WhiteColor,
    onPrimary = BlackColor,
    onBackground = BlackColor

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MovieAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider( LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}