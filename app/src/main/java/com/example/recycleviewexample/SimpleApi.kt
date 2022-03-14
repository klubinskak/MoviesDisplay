package com.example.exampleretrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {
    @GET("/3/discover/movie/popular")
    suspend fun getPost(
        @Query("api_key") api: String = "f6ffe20bb76e429fb04260ee01c2a8cc"
    ): Results
}