package com.example.apod_nasa_api.data.source

import com.example.apod_nasa_api.data.model.ImageData
import kotlinx.coroutines.flow.Flow

internal interface ImageDataSource {

    suspend fun getPhotoOfDay(): Flow<ImageData>
}