package com.skripsi.spotato_app.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skripsi.spotato_app.R

@Composable
fun Main() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .systemBarsPadding()
    ) {
        Image(
            imageVector = Icons.Filled.DateRange,
            contentDescription = "Riwayat prediksi",
            modifier = Modifier
                .align(Alignment.End)
                .size(30.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.AddCircle,
            contentDescription = "Potato image",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .size(200.dp)
        )
        Text(
            text = "Unggah Gambar",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
        Text(
            text = "Unggah gambar daun kentang dan lakukan prediksi kondisi daun kentang,",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
                .fillMaxWidth(),
            onClick = {

            }
        ) {
            Text(text = "Prediksi")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Main()
}