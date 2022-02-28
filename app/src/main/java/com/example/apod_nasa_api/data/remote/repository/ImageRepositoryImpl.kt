package com.example.apod_nasa_api.data.remote.repository

import com.example.apod_nasa_api.data.remote.model.toModel
import com.example.apod_nasa_api.data.remote.source.ImageDataSource
import com.example.apod_nasa_api.domain.model.ImageModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ImageRepositoryImpl(private val dataSource: ImageDataSource) : ImageRepository {
    override suspend fun getPhoto(): Flow<ImageModel> {
        return dataSource.getPhotoOfDay().map { it.toModel() }
    }
}