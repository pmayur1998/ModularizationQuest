package com.azabost.quest.lifecycle.impl.di

import android.app.Application
import com.azabost.quest.lifecycle.api.SharingActivityHolder
import com.azabost.quest.lifecycle.impl.ActivityLifecycleCallbacks
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LifecycleModule {

    @Binds
    fun activityLifecycleCallbacks(activityLifecycleCallbacks: ActivityLifecycleCallbacks): Application.ActivityLifecycleCallbacks

    @Binds
    fun sharingActivityHolder(activityLifecycleCallbacks: ActivityLifecycleCallbacks): SharingActivityHolder
}