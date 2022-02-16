package com.example.apod_nasa_api.data.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

internal interface GetApiKeyService {

    @GET("apod")
    suspend fun getImagePhoto(): Flow<Unit>
}