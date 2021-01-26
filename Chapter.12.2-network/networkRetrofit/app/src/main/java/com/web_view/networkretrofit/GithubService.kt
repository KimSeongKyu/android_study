package com.web_view.networkretrofit

import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("users/Kotlin/repos")
    fun users(): Call<List<RepositoryItem>>
}