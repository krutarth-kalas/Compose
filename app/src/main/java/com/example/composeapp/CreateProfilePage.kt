package com.example.composeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme
import java.time.format.TextStyle

class CreateProfilePage : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                ProfilePage()
                /*  Scaffold(
                      topBar = {
                          TopAppBar(
                              title = {
                                  Text(text = "Create Profile")
                              }
                          )
                      }
                  )
                  {
                      ProfilePage()
                  }*/
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProfilePage() {
        val name = remember { mutableStateOf("") }
        val lastname = remember { mutableStateOf("") }
        val mobileNumber = remember { mutableStateOf("") }
        val Email = remember { mutableStateOf("") }
        val PinCode = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "CREATE PROFILE", modifier = Modifier.align(Alignment.End), color = Color.Black, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)

            TextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Blue),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text
                ),
               placeholder = {
                    Text(text = "name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            TextField(
                value = lastname.value,
                onValueChange = {
                    lastname.value = it
                },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Blue),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text
                ),
                placeholder = {
                    Text(text = "last name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            TextField(
                value = mobileNumber.value,
                onValueChange = {
                    mobileNumber.value = it
                },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Blue),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text
                ),
                placeholder = {
                    Text(text = "Mobile")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            TextField(
                value = Email.value,
                onValueChange = {
                    Email.value = it
                },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Blue),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text
                ),
                placeholder = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            TextField(
                value = PinCode.value,
                onValueChange = {
                    PinCode.value = it
                },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Blue),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text
                ),
                placeholder = {
                    Text(text = "PinCode")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Button(onClick = {},modifier = Modifier.fillMaxWidth().padding(10.dp).align(Alignment.CenterHorizontally)) {
                Text(text = "NEXT")
            }
        }
    }
}