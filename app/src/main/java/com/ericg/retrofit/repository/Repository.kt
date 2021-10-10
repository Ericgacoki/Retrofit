package com.ericg.retrofit.repository

import com.ericg.retrofit.api.RetrofitInstance
import com.ericg.retrofit.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPosts(): Response<List<Post>> {
        return RetrofitInstance.api.getPosts()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int): Response<List<Post>>{
        return RetrofitInstance.api.getCustomPosts(userId)
    }

    suspend fun pushPost(post: Post): Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }
}