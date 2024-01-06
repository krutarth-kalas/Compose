package com.example.composeapp.basicconcept

import android.widget.CheckBox
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun CheckBoxUI(){

    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Checkbox(checked = isChecked, onCheckedChange = {
            isChecked = it
        },
            //not able to set shape. size thats y create custom checkbox
            colors = CheckboxDefaults.colors(checkedColor = Color.Yellow, checkmarkColor = Color.Black)
            //modifier = androidx.compose.ui.Modifier.size(40.dp).clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
        CustomCheckBox()
    }
}

@Composable
fun CustomCheckBox(){

    var isCheck by remember { mutableStateOf(false) }

    Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(),
        horizontalArrangement = Arrangement.Center)
    {
        
        Card(
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Black)
            //colors = Color.White
        ) {

            Box(modifier = androidx.compose.ui.Modifier
                .background(
                    if (isCheck) Color.Green else Color.White
                ).clickable {
                    isCheck = !isCheck
                }
                .size(25.dp), contentAlignment = Alignment.Center
            ){
                if (isCheck){
                    Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)
                }
            }
        }

        Text(text = "Accept all terms conditions", modifier = androidx.compose.ui.Modifier
            .padding(start = 5.dp)
            .align(CenterVertically))
    }
}