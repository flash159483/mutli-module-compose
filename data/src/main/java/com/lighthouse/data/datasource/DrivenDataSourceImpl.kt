package com.lighthouse.data.datasource

import com.lighthouse.data.api.DrivenApiService
import com.lighthouse.data.util.NetworkResponse
import com.lighthouse.domain.response.ViewTypeVO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DrivenDataSourceImpl @Inject constructor(
    private val api: DrivenApiService
) : DrivenDataSource, NetworkResponse() {
    override fun getDriven(): Flow<List<ViewTypeVO>> = flow {
        emit(changeResult(api.getDrivenData()))
    }
}