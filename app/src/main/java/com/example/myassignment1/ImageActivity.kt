package com.example.myassignment1

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

class ImageActivity : ComponentActivity() {
    private var capturedImage by mutableStateOf<Bitmap?>(null)

    private val takePicture = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as? Bitmap
            capturedImage = imageBitmap
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageScreen(
                capturedImage = capturedImage,
                onCaptureImage = {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    takePicture.launch(intent)
                },
                onBackToMain = {
                    finish()
                }
            )
        }
    }
}

@Composable
fun ImageScreen(
    capturedImage: Bitmap?,
    onCaptureImage: () -> Unit,
    onBackToMain: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onCaptureImage) {
            Text("Capture Image")
        }
        Spacer(modifier = Modifier.height(16.dp))
        capturedImage?.let { bitmap ->
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Captured image",
                modifier = Modifier.size(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBackToMain) {
            Text("Back to Main Activity")
        }
    }
}