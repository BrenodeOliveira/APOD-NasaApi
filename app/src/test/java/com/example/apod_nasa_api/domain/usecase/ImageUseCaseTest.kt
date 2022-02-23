package com.example.apod_nasa_api.domain.usecase

import com.example.apod_nasa_api.data.repository.ImageRepository
import com.example.apod_nasa_api.domain.model.ImageModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
internal class ImageUseCaseTest {

    private val imageModel = ImageModel("", "", "", "", "", "", "", "")
    private val repository = mockk<ImageRepository>(relaxed = true)
    private val useCase = ImageUseCase(repository)

    @Test
    fun `useCase Should return a ImageModel When repository return success`() {
        //Given
        coEvery { repository.getPhoto() } returns flowOf(imageModel)
        //When
        runBlockingTest {
            val result = useCase.invoke()

            //Then
            assertEquals(imageModel, result.first())
        }
    }
}