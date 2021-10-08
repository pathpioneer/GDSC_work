package com.example.myapplication.week3

import android.widget.ProgressBar
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun mainScreen() {
    var progressCount by remember { mutableStateOf(0.0f) }
    val progressCountAnimation by animateFloatAsState(
        targetValue = progressCount,
        tween(
            durationMillis = 1000,
            delayMillis = 100,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        // 텍스트 (0/10 부터 시작)
        ProgressBarText(progressCount)
        Spacer(modifier = Modifier.height(30.dp))
        // 막대 바
        ProgressBar(progressCountAnimation)
        Spacer(modifier = Modifier.height(30.dp))
        // 다음으로 넘어가는 버튼
        Button(onClick = {
            if (progressCount < 10) {
                progressCount += 1
            }
        }) {
            Text("다음 카드로 넘어가기")
        }
    }
}

@Composable
fun ProgressBarText(progressCount: Float) {
    Text("${progressCount.toInt()} / 10", style = MaterialTheme.typography.h5)
}

@Composable
fun ProgressBar(progressCountAnimation: Float) {
    LinearProgressIndicator(progressCountAnimation/10)
}

