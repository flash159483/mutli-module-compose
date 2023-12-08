package com.lighthouse.multi_module_compose.di

import com.lighthouse.data.datasource.StackOverFlowDataSource
import com.lighthouse.data.repository.QuestionRepositoryImpl
import com.lighthouse.domain.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideDrivenRepository(dataSource: StackOverFlowDataSource): QuestionRepository {
        return QuestionRepositoryImpl(dataSource)
    }
}