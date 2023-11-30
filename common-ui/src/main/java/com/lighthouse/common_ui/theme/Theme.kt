package com.lighthouse.common_ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf

private val CustomDarkColors = CustomColors(
    backgroundColor = Black,
    buttonBackgroundColor = DarkSkyBlue,
    buttonIconColor = Cyan,
    textColor = White,
    iconColor = DarkCyan,
    borderColor = DarkBlue700,
    errorColor = Red,
    buttonTextColor = White
)

private val CustomLightColors = CustomColors(
    backgroundColor = White,
    buttonBackgroundColor = LightSkyBlue,
    buttonIconColor = DarkCyan,
    textColor = Black,
    iconColor = Cyan,
    borderColor = DarkBlue100,
    errorColor = LightRed,
    buttonTextColor = White
)

private val LocalColorsProvider = staticCompositionLocalOf {
    CustomLightColors
}

@Composable
private fun CustomLocalProvider(colors: CustomColors, content: @Composable () -> Unit) {
    val colorPalette = remember {
        colors.copy()
    }

    colorPalette.update(colors)
    CompositionLocalProvider(LocalColorsProvider provides colorPalette, content = content)
}

private val CustomTheme.colors: Pair<ColorScheme, CustomColors>
    get() = when (this) {
        CustomTheme.LIGHT -> lightColorScheme() to CustomLightColors
        CustomTheme.DARK -> darkColorScheme() to CustomDarkColors
    }

object CustomThemeManager {
    val colors: CustomColors
        @Composable
        get() = LocalColorsProvider.current

    val fontType
        @Composable
        get() = MaterialTheme.typography

    val shapes
        @Composable
        get() = MaterialTheme.shapes


    var customTheme by mutableStateOf(CustomTheme.LIGHT)

    fun isSystemInDarkTheme(): Boolean {
        return customTheme == CustomTheme.DARK
    }
}

@Composable
fun MultiModuleComposeTheme(
    customTheme: CustomTheme = CustomThemeManager.customTheme,
    content: @Composable () -> Unit
) {
    val (colorPlatte, colors) = customTheme.colors
    CustomLocalProvider(colors = colors) {
        MaterialTheme(
            colorScheme = colorPlatte,
            content = content,
            typography = StaticTypeScale.Default.Copy(),
            shapes = Shapes,
        )
    }
}
