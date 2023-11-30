package com.lighthouse.multi_module_compose.di

import com.lighthouse.data.api.DrivenApiService
import com.lighthouse.data.datasource.DrivenDataSource
import com.lighthouse.data.datasource.DrivenDataSourceImpl
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
    fun provideDrivenDataSource(api: DrivenApiService): DrivenDataSource {
        return DrivenDataSourceImpl(api)
    }
}