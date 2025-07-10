package com.azabost.quest.time.impl.di

import com.azabost.quest.time.api.NowProvider
import com.azabost.quest.time.impl.DefaultNowProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface TimeModule {

    @Binds
    fun nowProvider(defaultNowProvider: DefaultNowProvider): NowProvider
}