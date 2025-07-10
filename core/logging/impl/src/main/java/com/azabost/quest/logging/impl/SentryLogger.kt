package com.azabost.quest.logging.impl

import com.azabost.quest.logging.api.Logger
import javax.inject.Inject
import javax.inject.Singleton

class SentryLogger(override val name: String) : Logger {

    @Singleton
    class Factory @Inject constructor() : Logger.Factory {
        override fun create(name: String): Logger = SentryLogger(name)
    }

    override fun debug(message: String) {
        // Fake implementation. Normally, this would invoke Sentry SDK.
        println("[$name] [D] $message")
    }

    override fun info(message: String) {
        // Fake implementation. Normally, this would invoke Sentry SDK.
        println("[$name] [I] $message")
    }

    override fun error(message: String, throwable: Throwable?) {
        // Fake implementation. Normally, this would invoke Sentry SDK.
        val stacktrace = throwable?.stackTraceToString()

        if (stacktrace != null) {
            println("[$name] [E] $message\n$stacktrace")
        } else {
            println("[$name] [E] $message")
        }
    }
}