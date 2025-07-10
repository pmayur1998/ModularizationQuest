package com.azabost.quest.share.api

import com.azabost.quest.posts.api.Post

interface SharePostUseCase {
    fun execute(post: Post)
}