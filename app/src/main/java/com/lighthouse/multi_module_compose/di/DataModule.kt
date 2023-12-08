package com.lighthouse.multi_module_compose.di

import com.lighthouse.data.api.StackOverFlowApi
import com.lighthouse.data.datasource.StackOverFlowDataSource
import com.lighthouse.data.datasource.StackOverFlowDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideDrivenDataSource(api: StackOverFlowApi): StackOverFlowDataSource {
        return StackOverFlowDataSourceImpl(api)
    }
}