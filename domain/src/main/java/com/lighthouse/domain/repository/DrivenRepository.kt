package com.lighthouse.domain.repository

import com.lighthouse.domain.response.ViewTypeVO
import kotlinx.coroutines.flow.Flow

interface DrivenRepository {
    fun getDriven(): Flow<List<ViewTypeVO>>
}