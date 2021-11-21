package com.example.myapplication.week3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navi() {

    // navController 생성
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ScreenA") {
        composable("ScreenA") {
            Column() {
                Text(
                    text = "Screen A",
                    style = MaterialTheme.typography.h3
                )
                Button(onClick = { navController.navigate("ScreenB") }) {
                    Text("GO TO B")
                }
                Button(onClick = { navController.navigate("ScreenC") }) {
                    Text("GO TO C")
                }
            }
        }
        composable("ScreenB") {
            Column() {
                Text(
                    text = "Screen B",
                    style = MaterialTheme.typography.h3
                )
                Button(onClick = { navController.navigate("ScreenC") }) {
                    Text("GO TO C")
                }
            }
        }
        composable("ScreenC") {
            Column() {
                Text(
                    text = "Screen C",
                    style = MaterialTheme.typography.h3
                )
                Button(onClick = { navController.navigate("ScreenD") }) {
                    Text("GO TO D")
                }
            }
        }
        composable("ScreenD") {
            Column() {
                Text(
                    text = "Screen D",
                    style = MaterialTheme.typography.h3
                )
                Button(onClick = { navController.navigate("ScreenA") }) {
                    Text("GO TO A")
                }
            }
        }
    }
}
