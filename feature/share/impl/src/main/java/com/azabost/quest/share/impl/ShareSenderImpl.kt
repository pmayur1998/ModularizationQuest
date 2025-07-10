package com.azabost.quest.share.impl

import android.content.Intent
import com.azabost.quest.lifecycle.api.SharingActivityHolder
import com.azabost.quest.share.api.ShareResult
import javax.inject.Inject

class ShareSenderImpl @Inject constructor(
    private val sharingActivityHolder: SharingActivityHolder,
) {

    fun share(text: String): ShareResult {
        val activity = sharingActivityHolder.getSharingActivity()
            ?: return ShareResult.Failure(kotlin.IllegalStateException("No sharing activity"))

        return try {
            val intent = createShareTextIntent(text)
            activity.startActivity(intent)
            ShareResult.Success
        } catch (e: Exception) {
            ShareResult.Failure(e)
        }
    }

    private fun createShareTextIntent(text: String): Intent = Intent.createChooser(
        Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        },
        null,
    )
} 