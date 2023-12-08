package com.lighthouse.data.model.response

import com.google.gson.annotations.SerializedName
import com.lighthouse.domain.response.QuestionListVO

data class QuestionListDTO(
    @SerializedName("items")
    val questions: List<QuestionDTO>?,
) {
    fun toVO() = QuestionListVO(
        questions = questions?.map { it.toVO() } ?: listOf()
    )
}