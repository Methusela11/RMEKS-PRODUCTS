package com.example.jobsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jobsapp.AdminUploadScreen
import com.example.jobsapp.screens.*

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "welcome") {

        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("signup") { SignupScreen(navController) }
        composable("home") { HomeScreen() }
        composable("jobs") { JobsScreen() }
        composable("admin") { AdminUploadScreen() }
    }
}