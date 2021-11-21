package com.example.week7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week7.ui.theme.MyApplicationTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// 안드로이드 7주차 복습!

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sampleScreen()
        }
    }
}


// 아래는 CreateScreen.kt에 대한 복습
@ExperimentalPagerApi
@Composable
fun sampleScreen() {
    val pagerState = rememberPagerState()
    val composableScope = rememberCoroutineScope()
    Column() {
        Samplepager(pagerState = pagerState, composableScope = composableScope)
        Text(
            text = "${pagerState.currentPage + 1} / ${pagerState.pageCount}",
            fontSize = 30.sp, fontWeight = FontWeight.Bold
        )
        HorizontalPagerIndicator(pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun Samplepager(pagerState: PagerState, composableScope: CoroutineScope) {
    HorizontalPager(
        count = 10,
        state = pagerState,
        contentPadding = PaddingValues(32.dp),
        modifier = Modifier
            .padding(8.dp)
            .background(Color.LightGray)
            .fillMaxHeight(.8f)
    ) { page ->
        Row(
            modifier = Modifier
                .background(Color.Magenta)
                .border(2.dp, Color.Black)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                composableScope.launch {
                    pagerState.scrollToPage(0)
                }
            }) {
                Text("<<")
            }
            Text(
                text = "      ${page + 1}/${pagerState.pageCount}      ",
                fontSize = 40.sp
            )
            Button(onClick = {
                composableScope.launch {
                    pagerState.scrollToPage(9)
                }
            }) {
                Text(">>")
            }
        }
    }
}