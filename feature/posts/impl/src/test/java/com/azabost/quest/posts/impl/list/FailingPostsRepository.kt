package com.azabost.quest.posts.impl.list

import com.azabost.quest.posts.api.Post
import com.azabost.quest.posts.api.repository.PostsRepository

class FailingPostsRepository : PostsRepository {
    override suspend fun getPosts(): List<Post> = throw RuntimeException("Network error")
    override suspend fun getPost(id: Int): Post? = throw RuntimeException("Network error")
}