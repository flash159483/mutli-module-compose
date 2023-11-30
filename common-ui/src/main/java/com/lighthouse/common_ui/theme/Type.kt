package com.lighthouse.common_ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.lighthouse.common_ui.R
import com.lighthouse.common_ui.util.textDp

internal val plainTextFont = FontFamily(
    Font(R.font.roboto_regular),
    Font(R.font.roboto_italic, style = FontStyle.Italic),
    Font(R.font.roboto_bold, weight = FontWeight.Bold),
    Font(R.font.roboto_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
)

internal val numberTextFont = FontFamily(
    Font(R.font.lato_regular),
    Font(R.font.lato_italic, style = FontStyle.Italic),
    Font(R.font.lato_bold, weight = FontWeight.Bold),
    Font(R.font.lato_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
)

private const val HeadLineHeightPercent = 1.1f
private const val BodyLineHeightPercent = 1.4f

@Stable
class StaticTypeScale private constructor(
    val fontFamily: FontFamily,
    val fontWeight: FontWeight,
    val fontSize: Int,
    val lineHeight: Float,
) {
    companion object {
        val Default = TypeScale(
            _display = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 48,
                lineHeight = 48 * HeadLineHeightPercent,
            ),
            _h1 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 32,
                lineHeight = 32 * HeadLineHeightPercent,
            ),
            _h2 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 32,
                lineHeight = 32 * HeadLineHeightPercent,
            ),
            _h3 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 24,
                lineHeight = 24 * HeadLineHeightPercent,
            ),
            _h4 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20,
                lineHeight = 20 * HeadLineHeightPercent,
            ),
            _h5 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 18,
                lineHeight = 18 * HeadLineHeightPercent,
            ),
            _h6 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16,
                lineHeight = 16 * HeadLineHeightPercent,
            ),
            _subtitle = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 14,
                lineHeight = 14 * HeadLineHeightPercent,
            ),
            _subhead = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 12,
                lineHeight = 12 * HeadLineHeightPercent,
            ),
            _body1 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 16,
                lineHeight = 16 * BodyLineHeightPercent,
            ),
            _body2 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 14,
                lineHeight = 14 * BodyLineHeightPercent,
            ),
            _body3 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 12,
                lineHeight = 12 * BodyLineHeightPercent,
            ),
            _caption = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 10,
                lineHeight = 10 * BodyLineHeightPercent,
            ),
            _numbersTitle = StaticTypeScale(
                fontFamily = numberTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 24,
                lineHeight = 24 * HeadLineHeightPercent,
            ),
            _numbers1 = StaticTypeScale(
                fontFamily = numberTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 18,
                lineHeight = 18 * BodyLineHeightPercent,
            ),
            _numbers2 = StaticTypeScale(
                fontFamily = numberTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 14,
                lineHeight = 14 * BodyLineHeightPercent,
            ),
            _numbers3 = StaticTypeScale(
                fontFamily = numberTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 12,
                lineHeight = 12 * BodyLineHeightPercent,
            ),
            _numbers4 = StaticTypeScale(
                fontFamily = numberTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 10,
                lineHeight = 10 * BodyLineHeightPercent,
            ),
            _numbers16 = StaticTypeScale(
                fontFamily = numberTextFont,
                fontWeight = FontWeight.Normal,
                fontSize = 16,
                lineHeight = 16 * BodyLineHeightPercent,
            ),
            _button1 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16,
                lineHeight = 16 * HeadLineHeightPercent,
            ),
            _button2 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 14,
                lineHeight = 14 * HeadLineHeightPercent,
            ),
            _button3 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 12,
                lineHeight = 12 * HeadLineHeightPercent,
            ),
            _button4 = StaticTypeScale(
                fontFamily = plainTextFont,
                fontWeight = FontWeight.Bold,
                fontSize = 10,
                lineHeight = 10 * HeadLineHeightPercent,
            ),
        )
    }
}

private val StaticTypeScale.textStyle: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize.textDp,
        lineHeight = lineHeight.textDp,
    )

@Immutable
data class TypeScale constructor(
    private val _display: StaticTypeScale,
    private val _h1: StaticTypeScale,
    private val _h2: StaticTypeScale,
    private val _h3: StaticTypeScale,
    private val _h4: StaticTypeScale,
    private val _h5: StaticTypeScale,
    private val _h6: StaticTypeScale,

    private val _subtitle: StaticTypeScale,
    private val _subhead: StaticTypeScale,
    private val _body1: StaticTypeScale,
    private val _body2: StaticTypeScale,
    private val _body3: StaticTypeScale,
    private val _caption: StaticTypeScale,

    private val _numbersTitle: StaticTypeScale,
    private val _numbers1: StaticTypeScale,
    private val _numbers2: StaticTypeScale,
    private val _numbers3: StaticTypeScale,
    private val _numbers4: StaticTypeScale,
    private val _numbers16: StaticTypeScale,

    private val _button1: StaticTypeScale,
    private val _button2: StaticTypeScale,
    private val _button3: StaticTypeScale,
    private val _button4: StaticTypeScale,
) {
    val display: TextStyle @Composable get() = _display.textStyle
    val h1: TextStyle @Composable get() = _h1.textStyle
    val h2: TextStyle @Composable get() = _h2.textStyle
    val h3: TextStyle @Composable get() = _h3.textStyle
    val h4: TextStyle @Composable get() = _h4.textStyle
    val h5: TextStyle @Composable get() = _h5.textStyle
    val h6: TextStyle @Composable get() = _h6.textStyle

    val subtitle: TextStyle @Composable get() = _subtitle.textStyle
    val subhead: TextStyle @Composable get() = _subhead.textStyle
    val body1: TextStyle @Composable get() = _body1.textStyle
    val body2: TextStyle @Composable get() = _body2.textStyle
    val body3: TextStyle @Composable get() = _body3.textStyle
    val caption: TextStyle @Composable get() = _caption.textStyle

    val numbersTitle: TextStyle @Composable get() = _numbersTitle.textStyle
    val numbers1: TextStyle @Composable get() = _numbers1.textStyle
    val numbers2: TextStyle @Composable get() = _numbers2.textStyle
    val numbers3: TextStyle @Composable get() = _numbers3.textStyle
    val numbers4: TextStyle @Composable get() = _numbers4.textStyle
    val numbers16: TextStyle @Composable get() = _numbers16.textStyle

    val button1: TextStyle @Composable get() = _button1.textStyle
    val button2: TextStyle @Composable get() = _button2.textStyle
    val button3: TextStyle @Composable get() = _button3.textStyle
    val button4: TextStyle @Composable get() = _button4.textStyle

    @Composable
    fun Copy() = Typography(
        displayLarge = display,
        displayMedium = h1,
        displaySmall = h2,
        headlineLarge = h3,
        headlineMedium = h4,
        headlineSmall = h5,
        titleLarge = h6,
        titleMedium = subtitle,
        titleSmall = subhead,
        bodyLarge = body1,
        bodyMedium = body2,
        bodySmall = body3,
        labelLarge = button1,
        labelMedium = button2,
        labelSmall = button3,
    )
}
