package com.example.composeapp.basicconcept.viewpager

import androidx.annotation.DrawableRes
import com.example.composeapp.R

data class ViewPagerDataSource(
    @DrawableRes val img : Int,
    val dec : String
)

val dataList = listOf(
    ViewPagerDataSource(R.drawable.language_settings,"ONE"),
    ViewPagerDataSource(R.drawable.ic_launcher_background,"TWO"),
    ViewPagerDataSource(R.drawable.language_settings,"THREE")
)