package com.skripsi.spotato_app.utils

import android.content.Context
import android.net.Uri
import java.io.File

fun uploadFile(uri: Uri?, context: Context): File {
    val fileName: String = "photo_" + System.currentTimeMillis() + ".jpg"
    val file = File(context.filesDir, fileName)
    file.createNewFile()
    if (uri != null) {
        context.contentResolver.openInputStream(uri)?.use { input ->
            file.outputStream().use { output ->
                input.copyTo(output)
            }
        }
    }
    return file
}