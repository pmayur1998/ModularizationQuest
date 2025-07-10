package com.azabost.quest.time.impl

import com.azabost.quest.time.api.NowProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultNowProvider @Inject constructor() : NowProvider {
    override fun now(): Long = System.currentTimeMillis()
} 