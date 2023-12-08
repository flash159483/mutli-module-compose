package com.lighthouse.home.ui

import com.lighthouse.domain.response.QuestionVO

data class HomeState(
    val isLoading: Boolean = false,
    val isError: String? = null,
    val errorMessage: String = "",
    val questions: List<QuestionVO> = emptyList(),
    val pageSize: Int = 30
)