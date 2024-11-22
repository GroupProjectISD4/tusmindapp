package com.example.tusmind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun TimerScreen(navController: NavHostController, initialTime: Int) {
    val timeLeft = remember { mutableStateOf(initialTime) } // Timer duration in seconds
    val progress = remember { mutableStateOf(1f) }

    LaunchedEffect(timeLeft.value) {
        if (timeLeft.value > 0) {
            delay(1000L) // 1 second delay
            timeLeft.value -= 1
            progress.value = timeLeft.value / initialTime.toFloat() // Update progress
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.popBackStack() // Navigate back
                        }
                )
                Spacer(modifier = Modifier.width(16.dp))
            }

            // Circular Timer
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(200.dp)
                ) {
                    androidx.compose.material3.CircularProgressIndicator(
                        progress = progress.value,
                        strokeWidth = 8.dp,
                        color = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = String.format(
                            "%02d:%02d",
                            timeLeft.value / 60,
                            timeLeft.value % 60
                        ),
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Start / Stop Button
                StartStopButton(
                    onStart = {
                        // Start timer logic
                        timeLeft.value = initialTime
                        progress.value = 1f
                    },
                    onStop = {
                        // Stop timer logic
                        timeLeft.value = 0
                        progress.value = 0f
                    }
                )
            }

            // Bottom Navigation Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Person, // Profile icon
                    contentDescription = "Profile",
                    tint = Color.White,
                    modifier = Modifier.clickable {  navController.navigate("profile") }
                )
                Icon(
                    imageVector = Icons.Filled.Home, // Home icon
                    contentDescription = "Home",
                    tint = Color.White,
                    modifier = Modifier.clickable { navController.navigate("home") }
                )
                Icon(
                    imageVector = Icons.Filled.Settings, // Settings icon
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.clickable { navController.navigate("settings") }
                )
            }
        }
    }
}

@Composable
fun StartStopButton(onStart: () -> Unit, onStop: () -> Unit) {
    // Remember state to toggle between "Start" and "Stop"
    val isRunning = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(
                color = Color(0xFF1D1D1D), // Button color
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                if (isRunning.value) {
                    // If running, stop the timer
                    onStop()
                } else {
                    // If not running, start the timer
                    onStart()
                }
                isRunning.value = !isRunning.value // Toggle the state
            }
            .padding(horizontal = 32.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isRunning.value) "Stop" else "Start", // Toggle text based on state
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimerScreenPreview() {
    // Preview with placeholder navigation
    TimerScreen(navController = rememberNavController(), initialTime = 300) // 5 minutes as an example
}
