package com.lighthouse.data.repository

import com.lighthouse.data.datasource.StackOverFlowDataSource
import com.lighthouse.domain.repository.QuestionRepository
import com.lighthouse.domain.response.QuestionListVO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val stackOverFlow: StackOverFlowDataSource,
) : QuestionRepository {
    override fun getQuestion(pageSize: Int?, page: Int): Flow<QuestionListVO> =
        stackOverFlow.getQuestions(pageSize, page, "NSJPlwhXqANj6PlgS1iUJQ((")
            .map {
                it.toVO()
            }
}