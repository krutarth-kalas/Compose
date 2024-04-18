package com.example.composeapp.basicconcept

import android.content.Context
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
//import android.hardware.Camera


@Composable
fun Test(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }
    val isCameraInitialized = remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        if (isCameraInitialized.value) {
            CameraPreview(
                modifier = Modifier.fillMaxSize(),
                //cameraProviderFuture = cameraProviderFuture,
                executor = cameraExecutor
            )
        }
    }

    DisposableEffect(Unit) {
        val cameraProvider = cameraProviderFuture.get()

        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(createSurfaceProvider(context))
        }

        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner, cameraSelector, preview
            )
            isCameraInitialized.value = true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        onDispose {
            cameraExecutor.shutdown()
        }
    }
}

@Composable
fun CameraPreview(
    modifier: Modifier = Modifier,
    //cameraProviderFuture: androidx.camera.lifecycle.ProcessCameraProvider.Future,
    executor: ExecutorService
) {
    //val viewFinder = rememberUpdatedState(ViewFinder())

    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val rect = Rect(
                topLeft = Offset(0f, 0f),
                bottomRight = Offset(0f, 0f)
            )
            drawRect(
                color = Color.White,
                topLeft = Offset(0f, 0f),
                size = size,
                style = Stroke(width = 2f)
            )
            drawRect(
                color = Color.Black,
                topLeft = Offset(rect.left, rect.top),
                size = Size(0f,0f)
            )
        }
    }
/*
    DisposableEffect(Unit) {
        val cameraProvider = cameraProviderFuture.get()

        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(createSurfaceProvider(ContextAmbient.current))
        }

            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                LocalLifecycleOwner.current, cameraSelector, preview
            )


        onDispose {
            executor.shutdown()
        }
    }*/
}

/*data class ViewFinder(
    val left: Float = 0f,
    val top: Float = 0f,
    val right: Float = 0f,
    val bottom: Float = 0f
)*/

private fun createSurfaceProvider(context: Context) = Preview.SurfaceProvider { surface ->
   /* val camera = Camera.open()

    camera.setPreviewDisplay(surface)
    camera.startPreview()*/
}
