package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.week2.ActionButton
import com.example.myapplication.week3.Navi
import com.example.myapplication.week3.SampleNavigation
import com.example.myapplication.week3.mainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    var curIndex by remember { mutableStateOf(0) }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("HomeScreen")
                            curIndex = 0
                        }
                        .padding(horizontal = 18.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(36.dp),
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        tint = if (curIndex==0) { Color.Black } else { Color.LightGray }
                    )
                    Text(
                        color = if (curIndex==0) { Color.Black } else { Color.LightGray },
                        text = "홈",
                        style = MaterialTheme.typography.body1
                    )
                }

                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("SearchScreen")
                            curIndex==1
                        }
                        .padding(horizontal = 18.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(36.dp),
                        imageVector = Icons.Outlined.Search,
                        contentDescription = null,
                        tint = if (curIndex==1) { Color.Black } else { Color.LightGray }
                    )
                    Text(
                        color = if (curIndex==1) { Color.Black } else { Color.LightGray },
                        text = "검색",
                        style = MaterialTheme.typography.body1
                    )
                }

                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("RatingScreen")
                            curIndex==2
                        }
                        .padding(horizontal = 18.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(36.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = if (curIndex==2) { Color.Black } else { Color.LightGray }
                    )
                    Text(
                        color = if (curIndex==2) { Color.Black } else { Color.LightGray },
                        text = "평가",
                        style = MaterialTheme.typography.body1
                    )
                }

                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("NewsScreen")
                            curIndex==3
                        }
                        .padding(horizontal = 18.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(36.dp),
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = if (curIndex==3) { Color.Black } else { Color.LightGray }
                    )
                    Text(
                        color = if (curIndex==3) { Color.Black } else { Color.LightGray },
                        text = "소식",
                        style = MaterialTheme.typography.body1
                    )
                }

                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("MyWatchaScreen")
                            curIndex==4
                        }
                        .padding(horizontal = 18.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(36.dp),
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = if (curIndex==4) { Color.Black } else { Color.LightGray }
                    )
                    Text(
                        color = if (curIndex==4) { Color.Black } else { Color.LightGray },
                        text = "나의 왓챠",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    ,
    content = {
        NavHost(navController = navController, startDestination = "HomeScreen") {
            composable("HomeScreen") {
                Text("홈 화면 !", fontSize = 30.sp)
            }
            composable("SearchScreen") {
                Text("검색 화면 !", fontSize = 30.sp)
            }
            composable("RatingScreen") {
                Text("평가 화면 !", fontSize = 30.sp)
            }
            composable("NewsScreen") {
                Text("소식 화면 !", fontSize = 30.sp)
            }
            composable("MyWatchaScreen") {
                Text("나의 왓챠 화면 !", fontSize = 30.sp)
            }
        }
    })
}