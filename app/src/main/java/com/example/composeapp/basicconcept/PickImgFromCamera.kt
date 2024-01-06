package com.example.composeapp.basicconcept

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

@Composable
fun PickImgFromCamera()
{
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()){
        bitmap = it
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { launcher.launch() }) {
            Text(text = "Pick Image from Camera")
        }

        Spacer(modifier = Modifier.height(20.dp))

        //check wheather bitmap null or not then Convert imgURI into Bitmap and then show

        bitmap?.let {
            Image(bitmap = bitmap?.asImageBitmap()!!, contentDescription = "", modifier = Modifier.size(200.dp) )
        }
    }
}