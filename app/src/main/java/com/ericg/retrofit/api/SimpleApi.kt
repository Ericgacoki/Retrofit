package com.ericg.retrofit.api

import com.ericg.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int
    ): Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>
}