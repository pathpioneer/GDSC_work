package com.example.myapplication

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.week2.ActionButton

@Composable
fun week2_main() {
    Column {
        showCount_1(modifier = Modifier.padding(10.dp))
        showCount_2(modifier = Modifier.padding(10.dp))
        ActionButton()
    }
}

/*
remember, mutableStateOf 키워드를 사용하지 않으면
recompose되었을 때 값이 바뀌지 않음
 */
@Composable
fun showCount_1(
    modifier: Modifier = Modifier
) {
    var count_1 = 0

    Column(modifier = Modifier.border(2.dp, Color.Black)) {
        Text(count_1.toString(), fontSize = 30.sp)
        Button(onClick = {
            count_1 += 1
        }) {
            Text("~~UP~~")
        }
    }
}

/*
mutableStateOf키워드를 사용해서 count값이 변경할 수 있으머
remember키워드를 사용하면서 recompose되었을 때 변경된 값을 기억할 수 있음
 */
@Composable
fun showCount_2(
    modifier: Modifier = Modifier
) {
    var count_2 = remember { mutableStateOf(0) }

    Column(modifier = Modifier.border(2.dp, Color.Black)) {
        Text(count_2.value.toString(), fontSize = 30.sp)
        Button(onClick = {
            count_2.value += 1
        }) {
            Text("~~UP~~")
        }
    }
}
