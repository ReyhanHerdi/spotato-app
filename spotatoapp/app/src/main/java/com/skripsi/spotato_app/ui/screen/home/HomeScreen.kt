package com.skripsi.spotato_app.ui.screen.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.skripsi.spotato_app.utils.mediaPicker
import com.skripsi.spotato_app.utils.uploadFile
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun Home(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val mediaPicker = mediaPicker()
    val image by viewModel.image.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .systemBarsPadding()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable {
                    mediaPicker.launch("image/*")
                }
        ) {
            LaunchedEffect(mediaPicker.uri) {
                viewModel.updateImage("${mediaPicker.uri}")
                Log.d("IMAGE", "${mediaPicker.uri}")
            }
            if (image == "null") {
                Row(
                    modifier = Modifier
                        .padding(top = 112.dp, bottom = 112.dp, start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Load image",
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = "Muat gambar",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.dp)
                    )
                }
            } else {
                AsyncImage(
                    model = image ,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Gambar yang dipilih",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(254.dp)
                )
            }
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,

            ),
            enabled = image != "null",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onClick = {
                coroutineScope.launch {
                    try {
                        val file = uploadFile(image.toUri(), context)
                        viewModel.upload(file)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        ) {
            Text(text = "Prediksi")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}