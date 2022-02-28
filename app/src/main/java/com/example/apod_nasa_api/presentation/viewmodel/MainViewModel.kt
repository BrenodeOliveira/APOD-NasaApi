package com.example.apod_nasa_api.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apod_nasa_api.domain.usecase.ImageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

internal class MainViewModel(private val useCase: ImageUseCase) : ViewModel() {

    private val _imageGenerated: MutableLiveData<String> = MutableLiveData()
    val imageGenerated: LiveData<String> = _imageGenerated
    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> = _loadingState
    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    fun generateImage() {
        viewModelScope.launch(Dispatchers.Main) {
            useCase()
                .flowOn(Dispatchers.IO)
                .onStart { handleLoading(true) }
                .catch { error -> handleError(error) }
                .onCompletion { handleLoading(false) }
                .collect { _imageGenerated.postValue(it.hdurl) }
        }
    }

    private fun handleLoading(state: Boolean) {
        _loadingState.postValue(state)
    }

    private fun handleError(error: Throwable) {
        _errorMessage.postValue(error.message)
    }
}