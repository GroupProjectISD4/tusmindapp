package com.example.tusmind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
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

        // Content
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle menu click */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }

                Text(
                    text = "Home",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.width(48.dp)) // Empty space to balance layout
            }

            // Main Buttons
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeButtonWithImage(
                    text = "Meditation Timer",
                    imageResId = R.drawable.meditation,
                    onClick = { navController.navigate("set_time") } // Navigate to Set Time Screen
                )
                Spacer(modifier = Modifier.height(16.dp))
                HomeButtonWithImage(
                    text = "Outdoor Activities",
                    imageResId = R.drawable.outdoor,
                    onClick = { navController.navigate("outdoor_activities") } // Navigate to Outdoor Activities Screen
                )
                Spacer(modifier = Modifier.height(16.dp))
                HomeButtonWithImage(
                    text = "Events",
                    imageResId = R.drawable.events,
                    onClick = { navController.navigate("events") } // Navigate to Events Screen
                )
            }

            // Bottom Navigation Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center, // Only Home button
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Home, // Home icon
                    contentDescription = "Home",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        navController.navigate("home") // Navigate to Home screen
                    }
                )
            }
        }
    }
}

@Composable
fun HomeButtonWithImage(text: String, imageResId: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(120.dp) // Increased height to ensure both image and text fit
            .background(
                color = Color(0xFF30766E), // Updated box color to #30766E
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick)
            .padding(8.dp), // Reduced padding to free up space
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image in the center
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = text,
            modifier = Modifier
                .size(68.dp) // Adjust size as needed
        )
        Spacer(modifier = Modifier.height(8.dp)) // Reduced spacer height to fit everything
        // Text below the image
        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp, // Slightly reduced font size for better fit
                color = Color(0xFF1D1D1D), // Custom color for the text
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}
