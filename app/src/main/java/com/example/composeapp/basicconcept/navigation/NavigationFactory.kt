package com.example.composeapp.basicconcept.navigation

sealed class NavigationFactory(val route : String)
{
    object FirstScreen : NavigationFactory("first")
    object SecondScreen : NavigationFactory("{data}/second"){
        fun createRoute(data:String) = "$data/second"
    }
    object ThirdScreen : NavigationFactory("third")

}
