package com.example.apod_nasa_api.data.source

import com.example.apod_nasa_api.data.remote.api.GetApiKeyService
import com.example.apod_nasa_api.data.remote.model.ImageData
import com.example.apod_nasa_api.data.remote.source.ImageDataSourceImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
internal class ImageDataSourceImplTest {

    private val imageData = ImageData("", "", "", "", "", "", "", "")
    private val service = mockk<GetApiKeyService>(relaxed = true)
    private val dataSource = ImageDataSourceImpl(service)

    @Test
    fun `dataSource Should return a ImageData When service returns success`() {
        //Given
        coEvery { service.getImagePhoto() } returns imageData
        //When
        runBlockingTest {
            val result = dataSource.getPhotoOfDay()

            //Then
            assertEquals(imageData, result.first())
        }
    }
}