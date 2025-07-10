package com.azabost.quest.posts.impl.list

import TestRecordingLoggerFactory
import com.azabost.quest.posts.api.Post
import com.azabost.quest.posts.api.repository.PostsRepository
import com.azabost.quest.posts.impl.model.SimplePostsRepository
import com.azabost.quest.posts.impl.ui.list.PostsViewModel
import io.kotest.inspectors.forAny
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.string.shouldContain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalCoroutinesApi::class)
class PostsViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val loggerFactory = TestRecordingLoggerFactory()
    private var postsRepository: PostsRepository = EmptyPostsRepository()
    private fun createViewModel() = PostsViewModel(postsRepository, loggerFactory)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun clear() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given 1 post in repository, when getPosts runs, then success is posted and debug log recorded`() = runTest {
        val singlePost = listOf(Post(1, "username", "title", "body"))
        postsRepository = SimplePostsRepository(singlePost)
        val viewModel = createViewModel()

        viewModel.getPosts()
        advanceUntilIdle()

        viewModel.uiState.value.shouldBeEqual(PostsViewModel.UiState.Success(singlePost))

        loggerFactory.debugMessages.forAny {
            it.message.shouldContain("Fetched 1 posts")
        }
    }

    @Test
    fun `given slow repository, when getPosts runs, then loading state is posted`() = runTest {
        postsRepository = SlowPostsRepository(10.seconds, EmptyPostsRepository())
        val viewModel = createViewModel()

        viewModel.getPosts()
        advanceTimeBy(5.seconds)

        viewModel.uiState.value.shouldBeEqual(PostsViewModel.UiState.Loading)
    }

    @Test
    fun `given repository fails, when getPosts runs, then error state is posted and error logged`() = runTest {
        postsRepository = FailingPostsRepository()
        val viewModel = createViewModel()

        viewModel.getPosts()
        advanceUntilIdle()

        viewModel.uiState.value.shouldBeEqual(PostsViewModel.UiState.Error)

        loggerFactory.errorMessages.forAny {
            it.message.shouldContain("Failed to fetch posts")
            it.throwable?.message.shouldContain("Network error")
        }
    }

}