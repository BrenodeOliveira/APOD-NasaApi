package com.example.apod_nasa_api.data.repository

import com.example.apod_nasa_api.domain.model.ImageModel
import kotlinx.coroutines.flow.Flow

internal interface ImageRepository {
    suspend fun getPhoto(): Flow<ImageModel>
}