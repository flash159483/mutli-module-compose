package com.lighthouse.data.api

import com.lighthouse.data.model.response.QuestionListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StackOverFlowApi {
    @GET("/questions?order=desc&sort=activity&site=stackoverflow")
    suspend fun lastActiveQuestions(
        @Query("pagesize") pageSize: Int?,
        @Query("page") page: Int,
        @Query("key") api: String
    ): Response<QuestionListDTO>

//    @GET("/questions/{questionId}?site=stackoverflow&filter=withbody")
//    suspend fun questionDetails(
//        @Path("questionId") questionId: String?,
//        @Query("key") api: String
//    ): Response<QuestionBodyDTO>
}