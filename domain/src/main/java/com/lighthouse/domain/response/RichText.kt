package com.lighthouse.domain.response

data class RichText(
    val textRichType: RichTextType?,
    val imageRichType: RichImageType?,
)


data class RichTextType(
    val text: String,
    val weight: Int?,
    val style: String?,
    val decoration: String?,
    val textColor: String?,
    val background: String?,
    val size: Float?,
)

data class RichImageType(
    val url: String,
    val width: Float?,
    val height: Float?,
)
