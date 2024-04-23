package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.todoapp.ui.theme.TodoAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoViewModel=ViewModelProvider(this)[TodoViewModel::class.java]
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "home") {
                composable("home") { DisplayImageForFiveSeconds(navController) }
                composable("details") { TodoApp(todoViewModel) }
            }
//            TodoAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    DisplayImageForFiveSeconds(navController)
//                    TodoApp(todoViewModel)
//                }
//            }
        }
    }
}


@Composable
fun DisplayImageForFiveSeconds(navController: NavController) {
    val showImage = remember { mutableStateOf(true) }

    // Show the image for 5 seconds

    if (showImage.value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // White background
            Box(
                modifier = Modifier
                    .size(200.dp) // Adjust the size as needed
                    .background(Color.White)
            )

            // Replace with your actual logo image
            Image(
                painter = painterResource(id = R.drawable.designer),
                contentDescription = "Your Logo",
                modifier = Modifier.size(100.dp)
            )
            Button(
                onClick = { navController.navigate("details") }, // Replace with your destination
                modifier = Modifier.padding(top = 144.dp)

            ) {
                Text("Go To App")
            }
        }
    }
}