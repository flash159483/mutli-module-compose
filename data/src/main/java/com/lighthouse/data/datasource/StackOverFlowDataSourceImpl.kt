package com.lighthouse.data.datasource

import com.lighthouse.data.api.StackOverFlowApi
import com.lighthouse.data.model.response.QuestionListDTO
import com.lighthouse.data.util.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StackOverFlowDataSourceImpl @Inject constructor(
    private val api: StackOverFlowApi
) : StackOverFlowDataSource, NetworkResponse() {
    override fun getQuestions(pageSize: Int?, page: Int, key: String): Flow<QuestionListDTO> =
        flow {
            emit(changeResult(api.lastActiveQuestions(pageSize, page, key)))
        }
}