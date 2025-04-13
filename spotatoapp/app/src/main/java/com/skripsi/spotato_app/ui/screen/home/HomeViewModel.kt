package com.skripsi.spotato_app.ui.screen.home

import androidx.lifecycle.ViewModel
import com.skripsi.spotato_app.repository.MainRepository
import com.skripsi.spotato_app.response.PredictionResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.File

class HomeViewModel(private val repository: MainRepository) : ViewModel() {
    private val _image = MutableStateFlow("uri")
    val image = _image.asStateFlow()

    fun updateImage(uri: String) {
        _image.value = uri
    }

    private val _result = MutableStateFlow(3)
    val result = _result.asStateFlow()

    fun updateResult(result: Int) {
        _result.value = result
    }

    suspend fun upload(
        file: File
    ): PredictionResponse = repository.upload(file)
}