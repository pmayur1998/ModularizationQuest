package com.azabost.quest.share.impl

import com.azabost.quest.analytics.Analytics
import com.azabost.quest.logging.api.Logger
import com.azabost.quest.logging.api.create
import com.azabost.quest.models.AnalyticsEvent
import com.azabost.quest.posts.api.Post
import com.azabost.quest.share.api.SharePostUseCase
import com.azabost.quest.share.api.ShareResult
import javax.inject.Inject

class SharePostUseCaseImpl @Inject constructor(
    private val analytics: Analytics,
    private val shareSender: ShareSenderImpl,
    loggerFactory: Logger.Factory,
) : SharePostUseCase {
    private val logger by lazy { loggerFactory.create(this::class) }

    override fun execute(post: Post) {
        val text = "${post.title}\n\n${post.body}"
        val shareResult = shareSender.share(text)
        when (shareResult) {
            ShareResult.Success -> analytics.logEvent(AnalyticsEvent.POST_SHARED)
            is ShareResult.Failure -> logger.error("Failed to share post", shareResult.reason)
        }
    }
}