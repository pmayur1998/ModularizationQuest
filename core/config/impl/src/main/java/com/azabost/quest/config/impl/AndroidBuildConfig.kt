package com.azabost.quest.config.impl

import com.azabost.quest.config.api.Config
import javax.inject.Inject

class AndroidBuildConfig @Inject constructor() : Config {
    override val isDebug: Boolean = BuildConfig.DEBUG
}