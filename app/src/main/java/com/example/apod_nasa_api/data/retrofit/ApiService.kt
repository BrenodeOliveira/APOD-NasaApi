package com.example.apod_nasa_api.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal const val BASE_URL = "https://api.nasa.gov/planetary/"

object ApiService {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}