package com.lighthouse.common_ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

enum class CustomTheme {
    LIGHT, DARK
}

val DarkSkyBlue = Color(0xFF71C9CE)
val LightSkyBlue = Color(0xFFE3FDFD)
val Black = Color(0xFF222222)
val White = Color(0xFFFFFFFF)

val YellowOrange700 = Color(0xFF916010)
val YellowOrange500 = Color(0xFFFAA21B)
val YellowOrange300 = Color(0xFFFDDAA4)
val YellowOrange100 = Color(0xFFFEECD1)

val Green700 = Color(0xFF5D822C)
val Green500 = Color(0xFF87B340)
val Green300 = Color(0xFFB7D78C)
val Green100 = Color(0xFFE7F2D9)

val DarkBlue700 = Color(0xFF12437F)
val DarkBlue500 = Color(0xFF4679B9)
val DarkBlue300 = Color(0xFFA3BCDC)
val DarkBlue100 = Color(0xFFE1EBF7)

val Cyan = Color(0xFF17A9A0)
val DarkCyan = Color(0xFF0B645F)

val Red = Color(0xFFD00036)
val LightRed = Color(0xFFFF8888)

val ShimmerColorShades = listOf(
    Color.LightGray.copy(0.9f),
    Color.LightGray.copy(0.2f),
    Color.LightGray.copy(0.9f)
)

@Stable
class CustomColors(
    backgroundColor: Color,
    buttonBackgroundColor: Color,
    buttonIconColor: Color,
    textColor: Color,
    iconColor: Color,
    borderColor: Color,
    errorColor: Color,
    buttonTextColor: Color
) {
    var backgroundColor by mutableStateOf(backgroundColor)
        private set

    var buttonBackgroundColor by mutableStateOf(buttonBackgroundColor)
        private set

    var buttonIconColor by mutableStateOf(buttonIconColor)
        private set

    var textColor by mutableStateOf(textColor)
        private set

    var iconColor by mutableStateOf(iconColor)
        private set

    var borderColor by mutableStateOf(borderColor)
        private set

    var errorColor by mutableStateOf(errorColor)
        private set

    var buttonTextColor by mutableStateOf(buttonTextColor)
        private set

    fun update(colors: CustomColors) {
        this.backgroundColor = colors.backgroundColor
        this.buttonBackgroundColor = colors.buttonBackgroundColor
        this.buttonIconColor = colors.buttonIconColor
        this.textColor = colors.textColor
        this.iconColor = colors.iconColor
        this.borderColor = colors.borderColor
        this.errorColor = colors.errorColor
    }

    fun copy() = CustomColors(
        backgroundColor = backgroundColor,
        buttonBackgroundColor = buttonBackgroundColor,
        buttonIconColor = buttonIconColor,
        textColor = textColor,
        iconColor = iconColor,
        borderColor = borderColor,
        errorColor = errorColor,
        buttonTextColor = buttonTextColor
    )
}
