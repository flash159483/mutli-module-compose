package com.lighthouse.data.api

import com.lighthouse.domain.response.ViewTypeVO
import retrofit2.Response
import retrofit2.http.GET

interface DrivenApiService {
    @GET("home")
    suspend fun getDrivenData(): Response<List<ViewTypeVO>>
}