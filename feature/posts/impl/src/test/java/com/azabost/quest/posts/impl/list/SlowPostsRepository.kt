package com.azabost.quest.posts.impl.list

import com.azabost.quest.posts.api.Post
import com.azabost.quest.posts.api.repository.PostsRepository
import kotlinx.coroutines.delay
import kotlin.time.Duration

class SlowPostsRepository(val delay: Duration, val other: PostsRepository) : PostsRepository {
    override suspend fun getPosts(): List<Post> {
        delay(delay)
        return other.getPosts()
    }

    override suspend fun getPost(id: Int): Post? {
        delay(delay)
        return other.getPost(id)
    }
}