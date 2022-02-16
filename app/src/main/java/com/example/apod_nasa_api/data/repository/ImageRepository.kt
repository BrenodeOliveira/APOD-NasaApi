package com.example.apod_nasa_api.data.repository

import kotlinx.coroutines.flow.Flow

internal interface ImageRepository {
    suspend fun getPhoto(): Flow<Unit>
}