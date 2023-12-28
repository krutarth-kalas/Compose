package com.example.composeapp.basicconcept.viewpager

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(){
    val pageState = rememberPagerState()

    Column {
        HorizontalPager(
            count = dataList.size,
            state = pageState,
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            //it returns index number
            pageUi(pager = dataList[it])
        }
        //to show indicator
        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(20.dp),
            activeColor = colorResource(id = R.color.purple_200)
        )
        AnimatedVisibility(visible = pageState.currentPage == 2) {
            Button(onClick = {  }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Getting Started")
                
            }
        }
    }
}

@Composable
fun pageUi(pager : ViewPagerDataSource)
{
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = pager.img), contentDescription = pager.dec, modifier = Modifier.size(200.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = pager.dec)
    }

}