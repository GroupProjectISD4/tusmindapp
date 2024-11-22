import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tusmind.Events
import com.example.tusmind.HomeScreen
import com.example.tusmind.MayorstoneMapUI
import com.example.tusmind.OutdoorActivitiesScreen
import com.example.tusmind.SetTimeScreen
import com.example.tusmind.ShelbourneMapUI
import com.example.tusmind.TimerScreen
import com.example.tusmind.WalkSelectionScreen
import com.example.tusmind.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    val navController = rememberNavController() // Controller for managing navigation

    NavHost(
        navController = navController,
        startDestination = "welcome" // Start screen
    ) {
        // Define destinations (screens)
        composable ("welcome") { WelcomeScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("set_time") { SetTimeScreen(navController) }
        composable("timer") { TimerScreen(navController, initialTime = 5) }
        composable("events") { Events(navController) }
        composable("outdoor_activities") { OutdoorActivitiesScreen(navController) }
        composable("mayorstone_map") { MayorstoneMapUI(navController) }
        composable("shelbourne_map") { ShelbourneMapUI(navController) }
        composable("walk-selection") { WalkSelectionScreen(navController) }
        composable("mayorstone") { MayorstoneMapUI(navController) }
        composable("shelbourne") { ShelbourneMapUI(navController) }
        composable("profile") { (navController) }

    }
}
