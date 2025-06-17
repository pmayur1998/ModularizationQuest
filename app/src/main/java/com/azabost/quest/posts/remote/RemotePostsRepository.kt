package com.azabost.quest.posts.remote

import com.azabost.quest.posts.model.Post
import com.azabost.quest.posts.model.PostsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemotePostsRepository @Inject constructor(private val postsService: PostsService) : PostsRepository {

    override suspend fun getPosts(): List<Post> = coroutineScope {
        val usersAsync = async { postsService.getUsers() }
        val postsAsync = async { postsService.getPosts() }

        postsAsync.await().map { post ->
            val user = usersAsync.await().first { it.id == post.userId }
            Post(
                id = post.id,
                userName = user.name,
                title = post.title,
                body = post.body
            )
        }
    }
}