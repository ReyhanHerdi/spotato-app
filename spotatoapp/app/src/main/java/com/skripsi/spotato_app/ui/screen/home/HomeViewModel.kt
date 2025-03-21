package com.skripsi.spotato_app.ui.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _image = MutableStateFlow("uri")
    val image = _image.asStateFlow()

    fun updateImage(uri: String) {
        _image.value = uri
    }
}