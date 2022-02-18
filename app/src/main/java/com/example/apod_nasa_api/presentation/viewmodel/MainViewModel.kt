package com.example.apod_nasa_api.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apod_nasa_api.domain.usecase.ImageUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class MainViewModel(private val useCase: ImageUseCase) : ViewModel() {

    private val _imageGenerated: MutableLiveData<String> = MutableLiveData()
    val imageGenerated: LiveData<String> = _imageGenerated

    fun generateImage() {
        viewModelScope.launch {
            useCase().collect { _imageGenerated.postValue(it.hdurl) }
        }
    }
}