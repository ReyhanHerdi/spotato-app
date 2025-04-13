package com.skripsi.spotato_app.api

import com.skripsi.spotato_app.response.PredictionResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("predict")
    suspend fun upload(
        @Part file: MultipartBody.Part
    ): PredictionResponse
}