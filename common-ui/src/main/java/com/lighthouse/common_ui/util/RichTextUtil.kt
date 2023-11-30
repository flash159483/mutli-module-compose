package com.lighthouse.common_ui.util

import android.content.Context
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lighthouse.domain.response.RichImageType
import com.lighthouse.domain.response.RichText
import com.lighthouse.domain.response.RichTextType

fun parseRichText(
    richText: List<RichText>,
    context: Context
): Pair<AnnotatedString, Map<String, InlineTextContent>> {
    var inlineContent = mapOf<String, InlineTextContent>()

    val content = buildAnnotatedString {
        richText.forEach {
            if (it.textRichType != null) {
                val text = it.textRichType!!
                withStyle(text.applyTextStyle()) {
                    append(text.text)
                }
            } else {
                val image = it.imageRichType!!
                inlineContent = inlineContent + image.applyImageStyle(context)
                appendInlineContent(id = image.url)
            }
        }
    }

    return Pair(content, inlineContent)
}

fun RichTextType.applyTextStyle(): SpanStyle {
    return SpanStyle(
        color = parseColor(this.textColor),
        background = parseColor(this.background),
        fontSize = this.size?.sp ?: 0.sp,
        fontWeight = FontWeight(this.weight ?: 500),
        fontStyle = this.style?.let {
            FontStyle.Italic
        },
        textDecoration = when (this.decoration) {
            "underline" -> TextDecoration.Underline
            "line-through" -> TextDecoration.LineThrough
            else -> TextDecoration.None
        }
    )
}

fun RichImageType.applyImageStyle(context: Context): Map<String, InlineTextContent> {
    return mapOf(
        this.url to InlineTextContent(
            Placeholder(
                this.width?.sp ?: 0.sp,
                this.height?.sp ?: 0.sp,
                PlaceholderVerticalAlign.Center
            )
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context).allowRgb565(true).data(this.url).build(),
                contentDescription = "image"
            )
        }
    )
}

private fun parseColor(color: String?): Color {
    return if (color.isNullOrEmpty()) {
        Color.Unspecified
    } else {
        Color(android.graphics.Color.parseColor(color))
    }
}