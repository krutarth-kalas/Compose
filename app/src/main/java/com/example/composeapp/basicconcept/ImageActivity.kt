package com.example.composeapp.basicconcept

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.composeapp.ui.theme.ComposeAppTheme

class ImageActivity : ComponentActivity()
{

    private val reqlauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){ isGranted->
        if (isGranted){
            Toast.makeText(this,"permission granted", Toast.LENGTH_LONG).show()
            //PickImgFromCamera()
        }else{
            Toast.makeText(this,"permission denied", Toast.LENGTH_LONG).show()

        }
    }

    //https://www.google.com/search?q=camera+using+rectangular+surface+in+jetpack+compose&rlz=1C1CHBF_enIN1064IN1064&oq=camera+using+reactangular+surfacev&gs_lcrp=EgZjaHJvbWUqCQgBECEYChigATIGCAAQRRg5MgkIARAhGAoYoAEyCQgCECEYChigATIICAMQIRgKGBXSAQkxODQ5MGowajSoAgCwAgE&sourceid=chrome&ie=UTF-8#fpstate=ive&vld=cid:016b3c52,vid:GRHQcl496P4,st:0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                //PickImgFromGallery()
                //PickImgFromCamera()
                requestCameraPermission()
            }
        }
    }

    @Composable
    private fun requestCameraPermission(){
        // Check permission
        when  {
            ContextCompat.checkSelfPermission(
                this,Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Toast.makeText(this,"permission previously granted", Toast.LENGTH_LONG).show()
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,Manifest.permission.CAMERA
            ) -> reqlauncher.launch(Manifest.permission.CAMERA)
                //Toast.makeText(this,"show camera permission dialog", Toast.LENGTH_LONG).show()

            else -> reqlauncher.launch(Manifest.permission.CAMERA)
        }
    }
}