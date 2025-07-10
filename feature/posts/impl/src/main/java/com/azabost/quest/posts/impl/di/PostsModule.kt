package com.azabost.quest.posts.impl.di

import com.azabost.quest.posts.api.PostsService
import com.azabost.quest.posts.api.repository.PostsRepository
import com.azabost.quest.posts.impl.remote.RemotePostsCache
import com.azabost.quest.posts.impl.remote.RemotePostsRepository
import com.azabost.quest.time.api.NowProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton
import kotlin.time.Duration.Companion.hours

@Module
@InstallIn(SingletonComponent::class)
interface PostsModule {

    @Binds
    fun postsRepository(repository: RemotePostsRepository): PostsRepository

    companion object {
        @Provides
        @Singleton
        fun postsService(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): PostsService =
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(converterFactory)
                .build()
                .create(PostsService::class.java)

        @Provides
        @Singleton
        fun remotePostsCache(nowProvider: NowProvider) =
            RemotePostsCache(
                cacheExpiryTimeMillis = 1.hours.inWholeMilliseconds,
                nowProvider = nowProvider,
            )
    }
}