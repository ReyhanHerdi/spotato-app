package com.skripsi.spotato_app.repository

import com.skripsi.spotato_app.response.PredictionResponse
import java.io.File

interface MainRepository {
    suspend fun upload(
        file: File
    ): PredictionResponse
}