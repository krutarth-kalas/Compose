package com.example.composeapp.basicconcept

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun PickImgFromGallery(){

    val context = LocalContext.current
    var img by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()){
        img = it
    }

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { launcher.launch("image/*") }) {
            Text(text = "Pick Image from gallery")
        }
        
        Spacer(modifier = Modifier.height(20.dp))

        //check wheather img null or not then Convert imgURI into Bitmap and then show
        img?.let {

            bitmap = if (Build.VERSION.SDK_INT < 28){
                MediaStore.Images.Media.getBitmap(context.contentResolver,it)
            }else{
                val source  = ImageDecoder.createSource(context.contentResolver,it)
                ImageDecoder.decodeBitmap(source)
            }

            Image(bitmap = bitmap?.asImageBitmap()!!, contentDescription = "", modifier = Modifier.size(200.dp) )
        }
    }

}