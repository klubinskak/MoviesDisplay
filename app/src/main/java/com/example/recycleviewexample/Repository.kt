package com.example.exampleretrofit

class Repository {

    suspend fun getPost(): Results{
        return RetrofitInstance.api.getPost()
    }
}
