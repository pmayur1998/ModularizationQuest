package com.azabost.quest.posts.api

import com.azabost.quest.posts.api.model.PostsResponse
import com.azabost.quest.posts.api.model.UsersResponse
import retrofit2.http.GET

interface PostsService {

    @GET("posts")
    suspend fun getPosts(): PostsResponse

    @GET("users")
    suspend fun getUsers(): UsersResponse

}