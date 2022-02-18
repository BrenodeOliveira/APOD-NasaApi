package com.example.apod_nasa_api.di

import com.example.apod_nasa_api.data.api.GetApiKeyService
import com.example.apod_nasa_api.data.repository.ImageRepository
import com.example.apod_nasa_api.data.repository.ImageRepositoryImpl
import com.example.apod_nasa_api.data.retrofit.ApiService
import com.example.apod_nasa_api.data.retrofit.HttpClient
import com.example.apod_nasa_api.data.source.ImageDataSource
import com.example.apod_nasa_api.data.source.ImageDataSourceImpl
import com.example.apod_nasa_api.domain.usecase.ImageUseCase
import com.example.apod_nasa_api.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory {
        HttpClient(retrofit = ApiService.initRetrofit())
    }

    factory {
        get<HttpClient>().create(
            service = GetApiKeyService::class.java
        )
    }

    factory<ImageDataSource> {
        ImageDataSourceImpl(service = get())
    }

    factory<ImageRepository> {
        ImageRepositoryImpl(
            dataSource = get()
        )
    }
}

val domainModule = module {
    factory {
        ImageUseCase(imageRepository = get())
    }
}

val presentationModule = module {
    viewModel {
        MainViewModel(useCase = get())
    }
}