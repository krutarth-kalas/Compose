package com.example.composeapp.basicconcept

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class StateManageViewModel : ViewModel() {
    val name : MutableState<String> = mutableStateOf("fkfkfkfk")
}