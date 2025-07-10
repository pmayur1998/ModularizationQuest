package com.azabost.quest.posts.impl.remote

import com.azabost.quest.posts.api.Post
import com.azabost.quest.time.api.NowProvider
import javax.inject.Singleton

@Singleton
class RemotePostsCache(
    private val cacheExpiryTimeMillis: Long,
    private val nowProvider: NowProvider
) {

    private var posts: List<Post>? = null
    private var storedAt: Long = 0

    @Synchronized
    fun store(posts: List<Post>) {
        this.posts = posts
        storedAt = nowProvider.now()
    }

    @Synchronized
    fun get(): List<Post>? {
        val isCacheExpired = storedAt + cacheExpiryTimeMillis < nowProvider.now()

        return if (isCacheExpired) {
            clear()
            null
        } else {
            posts
        }
    }

    @Synchronized
    fun clear() {
        posts = null
    }
}