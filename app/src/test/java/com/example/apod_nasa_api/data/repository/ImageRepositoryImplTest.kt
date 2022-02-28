package com.example.apod_nasa_api.data.repository

import com.example.apod_nasa_api.data.remote.model.ImageData
import com.example.apod_nasa_api.data.remote.model.toModel
import com.example.apod_nasa_api.data.remote.repository.ImageRepositoryImpl
import com.example.apod_nasa_api.data.remote.source.ImageDataSource
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
internal class ImageRepositoryImplTest {

    private val imageData = ImageData("", "", "", "", "", "", "", "")
    private val dataSource = mockk<ImageDataSource>(relaxed = true)
    private val repository = ImageRepositoryImpl(dataSource)

    @Test
    fun `repository Should return a ImageModel When dataSource returns success`() {
        //Given
        coEvery { dataSource.getPhotoOfDay() } returns flowOf(imageData)
        val imageModel = imageData.toModel()
        //When
        runBlockingTest {
            val result = repository.getPhoto()
            //Then
            assertEquals(imageModel, result.first())
        }
    }
}