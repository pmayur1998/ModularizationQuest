package com.azabost.quest.share.impl.di

import com.azabost.quest.share.api.SharePostUseCase
import com.azabost.quest.share.impl.SharePostUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ShareModule {

    @Binds
    fun sharePostUseCase(impl: SharePostUseCaseImpl): SharePostUseCase
}