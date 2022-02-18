package com.example.apod_nasa_api.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apod_nasa_api.domain.usecase.ImageUseCase

internal class MainViewModel(private val useCase: ImageUseCase) : ViewModel() {
    /**
     * Fazer a chamada do viewModel
     */
}