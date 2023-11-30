package com.lighthouse.home.ui

import com.lighthouse.domain.response.ViewTypeVO

data class HomeState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
    val drivenData: List<ViewTypeVO> = listOf()
)