package com.example.composeapp.basicconcept

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

class LoginActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LoginScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen()
    {
        val username = remember{ mutableStateOf("") }
        val password = remember{ mutableStateOf("") }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = "Login Screen", color = Color.Blue, fontSize = 25.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            Text(text = "Welcome", color = Color.Blue, fontSize = 25.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)

            //Todo for editText
            OutlinedTextField (
                value = username.value,
                onValueChange = {
                    username.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "Person")
                },
              /*  trailingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "Person")
                }*/
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "Enter UserName")
                },
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )

            OutlinedTextField (
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "Info")
                },
                /*  trailingIcon = {
                      Icon(Icons.Default.Person, contentDescription = "Person")
                  }*/
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                },
                modifier = Modifier.fillMaxWidth().padding(10.dp)

            )

            OutlinedButton(onClick = {loggedIn(username.value,password.value)},modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                Text(text = "Login")
            }

        }

    }

    private fun loggedIn(username : String, password : String)
    {
        if (username == "krutarth" && password =="1992"){
            Toast.makeText(this,"Logged In",Toast.LENGTH_LONG).show()
        }else{
         Toast.makeText(this,"wrong credential",Toast.LENGTH_LONG).show()
        }
    }
}