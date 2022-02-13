package com.example.apod_nasa_api.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.nasa.gov/planetary/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}