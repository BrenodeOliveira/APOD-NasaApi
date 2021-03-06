package com.example.apod_nasa_api.data.remote.source

import com.example.apod_nasa_api.data.remote.api.GetApiKeyService
import com.example.apod_nasa_api.data.remote.model.ImageData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class ImageDataSourceImpl(private val service: GetApiKeyService): ImageDataSource {

    override suspend fun getPhotoOfDay(): Flow<ImageData> {
        return flow { emit(service.getImagePhoto()) }
    }
}