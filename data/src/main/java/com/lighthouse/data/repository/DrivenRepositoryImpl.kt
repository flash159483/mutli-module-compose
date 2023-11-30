package com.lighthouse.data.repository

import com.lighthouse.data.datasource.DrivenDataSource
import com.lighthouse.domain.repository.DrivenRepository
import com.lighthouse.domain.response.ViewTypeVO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DrivenRepositoryImpl @Inject constructor(
    private val drivenDataSource: DrivenDataSource,
) : DrivenRepository {
    override fun getDriven(): Flow<List<ViewTypeVO>> =
        drivenDataSource.getDriven()
}