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
import androidx.navigation.NavHostController

@Composable
fun ShelbourneMapUI(navController: NavHostController) {
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
                    imageVector = Icons.Filled.ArrowBack, // Back icon
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Shelbourne Park",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
            }

            // Map Image
            Image(
                painter = painterResource(id = R.drawable.shelbournepark), // Replace with Shelbourne map image
                contentDescription = "Shelbourne Park Map",
                contentScale = ContentScale.Fit, // Ensure the full image is visible
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(vertical = 16.dp)
            )

            // Route Information
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Distance: 1.4 km",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
                Text(
                    text = "Time: 19 minutes",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
                Text(
                    text = "Start point: TUS Moylish Campus",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
                Text(
                    text = "End point: Shelbourne Park",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
            }

            // Start Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(
                        color = Color(0xFF1D1D1D), // Updated color to #1D1D1D
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { /* Handle start action */ }
                    .padding(horizontal = 32.dp, vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Start",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
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

@Preview(showBackground = true)
@Composable
fun ShelbourneMapUIPreview() {
    ShelbourneMapUI(
        navController = TODO()
    )
}
