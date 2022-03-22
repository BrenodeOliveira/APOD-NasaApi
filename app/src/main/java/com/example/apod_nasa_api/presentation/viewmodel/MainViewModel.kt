package com.example.apod_nasa_api.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apod_nasa_api.domain.model.toVO
import com.example.apod_nasa_api.domain.usecase.ImageUseCase
import com.example.apod_nasa_api.presentation.viewobject.ImageViewObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

internal class MainViewModel(private val useCase: ImageUseCase) : ViewModel() {

    private val _dataGenerated: MutableLiveData<ImageViewObject> = MutableLiveData()
    val dataGenerated: LiveData<ImageViewObject> = _dataGenerated
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
                .collect {
                    _dataGenerated.postValue(it.toVO())
                }
        }
    }

    private fun handleLoading(state: Boolean) {
        _loadingState.postValue(state)
    }

    private fun handleError(error: Throwable) {
        _errorMessage.postValue(error.message)
    }
}