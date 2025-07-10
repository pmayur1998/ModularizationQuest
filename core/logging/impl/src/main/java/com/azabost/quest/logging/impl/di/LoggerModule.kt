package com.azabost.quest.logging.impl.di

import com.azabost.quest.logging.api.Logger
import com.azabost.quest.logging.impl.CompositeLogger
import com.azabost.quest.logging.impl.LogcatLogger
import com.azabost.quest.logging.impl.SentryLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
interface LoggerModule {
    @Binds
    fun compositeLoggerfactory(compositeLoggerFactory: CompositeLogger.Factory): Logger.Factory

    @Binds
    @IntoSet
    fun logcatLoggerFactory(logcatLoggerFactory: LogcatLogger.Factory): Logger.Factory

    @Binds
    @IntoSet
    fun sentryLoggerFactory(sentryLoggerFactory: SentryLogger.Factory): Logger.Factory
}