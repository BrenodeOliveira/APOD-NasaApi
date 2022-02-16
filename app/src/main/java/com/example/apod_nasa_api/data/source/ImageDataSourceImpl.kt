package com.example.apod_nasa_api.data.source

import com.example.apod_nasa_api.data.api.GetApiKeyService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class ImageDataSourceImpl(private val service: GetApiKeyService): ImageDataSource {

    override suspend fun getPhotoOfDay(): Flow<Unit> {
        return flow { service.getImagePhoto() }
    }
}