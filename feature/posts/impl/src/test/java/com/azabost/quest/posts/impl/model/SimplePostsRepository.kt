package com.azabost.quest.posts.impl.model

import com.azabost.quest.posts.api.Post
import com.azabost.quest.posts.api.repository.PostsRepository

class SimplePostsRepository(var posts: List<Post>) : PostsRepository {
    override suspend fun getPosts(): List<Post> = posts
    override suspend fun getPost(id: Int): Post? = posts.find { it.id == id }
}