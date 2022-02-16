package com.example.apod_nasa_api.data.source

import kotlinx.coroutines.flow.Flow

internal interface ImageDataSource {

    suspend fun getPhotoOfDay(): Flow<Unit>
}