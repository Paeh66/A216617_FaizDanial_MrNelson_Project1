package com.example.a216617_mrnelson_project1

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// -------------------- NAVIGATION aku--------------------

@Composable
fun CityReportApp(viewModel: ReportViewModel = viewModel()) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            CityReportScreen(
                messages = viewModel.messages,
                onGoForm = { navController.navigate("form") },
                onGoList = { navController.navigate("list") },
                onGoStats = { navController.navigate("stats") },
                onGoProfile = { navController.navigate("profile") }
            )
        }

        composable("form") {
            FormScreen(
                onBack = { navController.popBackStack() },
                onSubmit = { selectedAgency, title, issue, location ->
                    viewModel.addMessage("Ask",selectedAgency, title, issue, location)
                    navController.popBackStack()
                }
            )
        }

        composable("list") {
            MessageListScreen(
                messages = viewModel.messages,
                onBack = { navController.popBackStack() },
                onItemClick = { index ->
                    navController.navigate("detail/$index")
                }
            )
        }

        composable("detail/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0
            val report = viewModel.messages[index]

            DetailScreen(
                report = report,
                onBack = { navController.popBackStack() }
            )
        }

        composable("profile") {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable("stats") {
            StatsScreen(viewModel = viewModel, onBack = { navController.popBackStack() })
        }
    }
}