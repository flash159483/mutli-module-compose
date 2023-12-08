package com.lighthouse.domain.repository

import com.lighthouse.domain.response.QuestionListVO
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestion(pageSize: Int?, page: Int): Flow<QuestionListVO>
}