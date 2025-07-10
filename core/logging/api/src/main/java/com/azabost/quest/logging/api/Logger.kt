package com.azabost.quest.logging.api

import com.azabost.quest.models.AnalyticsEvent
import kotlin.jvm.java
import kotlin.reflect.KClass

interface Logger {
    val name: String

    fun debug(message: String)
    fun info(message: String)
    fun error(message: String, throwable: Throwable? = null)

    interface Factory {
        fun create(name: String): Logger
    }
}

fun Logger.event(analyticsEvent: AnalyticsEvent) = info("event: ${analyticsEvent.key}")

fun Logger.Factory.create(kClass: KClass<*>): Logger = create(kClass.java.simpleName) 