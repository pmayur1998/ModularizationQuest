package com.azabost.quest.posts.api.repository

import com.azabost.quest.posts.api.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post?
}