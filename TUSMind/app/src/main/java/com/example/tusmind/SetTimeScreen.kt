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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SetTimeScreen(navController: NavController) {
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

            // Centered "Set time" Text
            Text(
                text = "Set time",
                style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // Set Time Buttons
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SetTimeButton("5", "Minutes") {
                        navController.navigate("timer") // Pass 5 minutes as initial time
                    }
                    SetTimeButton("10", "Minutes") {
                        navController.navigate("timer") // Pass 10 minutes as initial time
                    }
                }
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
fun SetTimeButton(number: String, unit: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .size(140.dp)
            .background(
                color = Color(0xFF30766E),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number,
            style = TextStyle(
                fontSize = 30.sp,
                color = Color(0xFF1D1D1D),
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = unit,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color(0xFF1D1D1D)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SetTimeScreenPreview() {
    SetTimeScreen(navController = rememberNavController())
}

