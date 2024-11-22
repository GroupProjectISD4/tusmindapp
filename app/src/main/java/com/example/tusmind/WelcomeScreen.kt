package com.example.tusmind

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center // Center everything in the Box
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Centering all content
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Vertically center the content
            horizontalAlignment = Alignment.CenterHorizontally // Horizontally center the content
        ) {
            // Logo image
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "TUS Mind Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 16.dp)
            )

            // Spacer to separate icon and text
            Spacer(modifier = Modifier.height(24.dp))

            // Welcome message
            Text(
                text = "Welcome to MindWalk",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            )

            // Spacer to separate text and button
            Spacer(modifier = Modifier.height(24.dp))

            // Button to navigate to the next screen
            Button(
                onClick = { navController.navigate("home") }, // Navigate to Home screen
                shape = RoundedCornerShape(12.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1D1D1D) // Updated color to #1D1D1D
                ),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
            ) {
                Text(
                    text = "Begin",
                    style = TextStyle(fontSize = 18.sp, color = Color.White)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController() // Mock NavController for preview
    WelcomeScreen(navController = navController)
}
