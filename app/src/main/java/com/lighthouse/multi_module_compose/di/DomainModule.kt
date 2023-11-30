package com.lighthouse.multi_module_compose.di

import com.lighthouse.data.datasource.DrivenDataSource
import com.lighthouse.data.repository.DrivenRepositoryImpl
import com.lighthouse.domain.repository.DrivenRepository
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
    fun provideDrivenRepository(dataSource: DrivenDataSource): DrivenRepository {
        return DrivenRepositoryImpl(dataSource)
    }
}