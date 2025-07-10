package com.azabost.quest.config.impl.di

import com.azabost.quest.config.impl.AndroidBuildConfig
import com.azabost.quest.config.api.Config
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ConfigModule {

    @Binds
    fun config(config: AndroidBuildConfig): Config
}