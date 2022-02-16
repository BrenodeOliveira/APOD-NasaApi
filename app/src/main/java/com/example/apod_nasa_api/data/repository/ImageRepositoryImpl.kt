package com.example.apod_nasa_api.data.repository

import com.example.apod_nasa_api.data.source.ImageDataSource
import kotlinx.coroutines.flow.Flow

internal class ImageRepositoryImpl(private val dataSource: ImageDataSource): ImageRepository {
    override suspend fun getPhoto(): Flow<Unit> {
        return dataSource.getPhotoOfDay()
    }
}