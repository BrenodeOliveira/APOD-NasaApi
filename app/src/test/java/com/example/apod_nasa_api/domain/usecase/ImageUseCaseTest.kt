package com.example.apod_nasa_api.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.apod_nasa_api.TestCoroutineRule
import com.example.apod_nasa_api.data.repository.ImageRepository
import com.example.apod_nasa_api.domain.model.ImageModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
internal class ImageUseCaseTest() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = TestCoroutineRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private val imageModel = ImageModel("", "", "", "", "", "", "", "")
    private val repository = mockk<ImageRepository>(relaxed = true)
    private val useCase = ImageUseCase(repository)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `useCase Should return a ImageModel When repository return success`()  {
        //Given
        coEvery { repository.getPhoto() } returns flowOf(imageModel)
        //When
        runBlockingTest {
            val result = useCase.invoke()

            //Then
            assertEquals(imageModel, result)
        }
    }
}