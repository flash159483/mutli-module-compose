package com.lighthouse.data.datasource

import com.lighthouse.data.model.response.QuestionListDTO
import kotlinx.coroutines.flow.Flow

interface StackOverFlowDataSource {
    fun getQuestions(pageSize: Int?, page: Int, key: String): Flow<QuestionListDTO>
}