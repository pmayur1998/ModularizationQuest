package com.azabost.quest.posts.impl.list

import com.azabost.quest.posts.api.Post
import com.azabost.quest.posts.api.repository.PostsRepository

class EmptyPostsRepository : PostsRepository {
    override suspend fun getPosts(): List<Post> = emptyList()
    override suspend fun getPost(id: Int): Post? = null
}