package com.lighthouse.multi_module_compose.di

import com.google.gson.GsonBuilder
import com.lighthouse.data.api.StackOverFlowApi
import com.lighthouse.data.api.ViewTypeDeserializer
import com.lighthouse.domain.response.ViewTypeVO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetModule {
    @Provides
    @Singleton
    fun provideDrivenRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/2.2/")
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .registerTypeAdapter(ViewTypeVO::class.java, ViewTypeDeserializer())
                        .create()
                )
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideDrivenOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    @Provides
    @Singleton
    fun provideDrivenApiService(retrofit: Retrofit): StackOverFlowApi =
        retrofit.create(StackOverFlowApi::class.java)
}

