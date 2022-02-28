package com.example.apod_nasa_api.data.remote.api

import com.example.apod_nasa_api.data.remote.model.ImageData
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "b3kgnrDEUrzuhCAHCtB6tZSNuRXylNDB0yt2hO5C"

internal interface GetApiKeyService {

    @GET("apod")
    suspend fun getImagePhoto(@Query("api_key") apiKey: String = API_KEY ): ImageData
}