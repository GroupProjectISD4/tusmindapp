package com.example.tusmind

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.TemporalAdjusters

@SuppressLint("NewApi")
@Composable
fun Events(navController: NavHostController) {
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
                    text = "Events",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
            }

            // Centered Event Cards
            Column {
                Text(
                    text = "Tap to set reminder",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
                EventCard(
                    title = "Mindful Monday's",
                    dateTime = "Every Monday @ TUS, The Reflection Room",
                    imageResId = R.drawable.eventsmeditation,
                    onScheduleNotification = { context ->
                        val eventTime = System.currentTimeMillis() + 2 * 1000
                        scheduleNotification(
                            context = context,
                            title = "Mindful Monday's",
                            message = "Join us @ TUS, The Reflection Room!",
                            timeInMillis = eventTime
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                EventCard(
                    title = "Yoga Class",
                    dateTime = "Every Tuesday @ TUS, Sportshub Moylish, €5 per person",
                    imageResId = R.drawable.eventsyoga,
                    onScheduleNotification = { context ->
                        val eventTime = System.currentTimeMillis() + 2 * 1000
                        scheduleNotification(
                            context = context,
                            title = "Yoga Class",
                            message = "Yoga @ Sportshub Moylish, only €5!",
                            timeInMillis = eventTime
                        )
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
fun EventCard(title: String, dateTime: String, imageResId: Int, onScheduleNotification: (Context) -> Unit
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = Color(0xFF30766E), // Box color
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onScheduleNotification(context) } // Trigger notification scheduling on click
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1D1D1D)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = dateTime,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF1D1D1D)
                    )
                )
            }
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 16.dp)
            )
        }
    }
}
@SuppressLint("NewApi")
fun calculateNextEventTime(dayOfWeek: DayOfWeek, hour: Int, minute: Int): Long {
    val now = LocalDateTime.now()
    val nextEvent = now.with(TemporalAdjusters.nextOrSame(dayOfWeek))
        .withHour(hour)
        .withMinute(minute)
        .withSecond(0)
        .withNano(0)

    return nextEvent.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}
@Preview(showBackground = true)
@Composable
fun EventsScreenPreview() {
    Events(
        navController = TODO()
    )
}
