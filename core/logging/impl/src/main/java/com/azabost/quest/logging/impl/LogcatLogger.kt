package com.azabost.quest.logging.impl

import android.util.Log
import com.azabost.quest.config.api.Config
import com.azabost.quest.logging.api.Logger
import javax.inject.Inject

class LogcatLogger(
    override val name: String,
    private val config: Config,
) : Logger {

    class Factory @Inject constructor(
        private val config: Config
    ) : Logger.Factory {
        override fun create(name: String): Logger = LogcatLogger(name, config)
    }

    override fun debug(message: String) {
        if (!config.isDebug) return
        Log.d(name, message)
    }

    override fun info(message: String) {
        Log.i(name, message)
    }

    override fun error(message: String, throwable: Throwable?) {
        Log.e(name, message, throwable)
    }
}