package com.lighthouse.data.datasource

import com.lighthouse.domain.response.ViewTypeVO
import kotlinx.coroutines.flow.Flow

interface DrivenDataSource {
    fun getDriven(): Flow<List<ViewTypeVO>>
}