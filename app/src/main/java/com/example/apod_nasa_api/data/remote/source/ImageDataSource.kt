package com.example.apod_nasa_api.data.remote.source

import com.example.apod_nasa_api.data.remote.model.ImageData
import kotlinx.coroutines.flow.Flow

internal interface ImageDataSource {

    suspend fun getPhotoOfDay(): Flow<ImageData>
}