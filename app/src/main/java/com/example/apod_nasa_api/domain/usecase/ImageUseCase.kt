package com.example.apod_nasa_api.domain.usecase

import com.example.apod_nasa_api.data.remote.repository.ImageRepository
import com.example.apod_nasa_api.domain.model.ImageModel
import kotlinx.coroutines.flow.Flow

internal class ImageUseCase(private val imageRepository: ImageRepository) {
    suspend operator fun invoke(): Flow<ImageModel> {
        return imageRepository.getPhoto()
    }
}