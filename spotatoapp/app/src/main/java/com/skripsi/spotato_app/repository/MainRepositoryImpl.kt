package com.skripsi.spotato_app.repository

import com.skripsi.spotato_app.api.ApiService
import com.skripsi.spotato_app.response.PredictionResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class MainRepositoryImpl(
    private val apiService: ApiService
): MainRepository {
    override suspend fun upload(
        file: File
    ): PredictionResponse {
        return apiService.upload(
            file = MultipartBody.Part.createFormData(
                name = "file",
                filename = file.name,
                file.asRequestBody("image/*".toMediaTypeOrNull())
            )
        )
    }
}