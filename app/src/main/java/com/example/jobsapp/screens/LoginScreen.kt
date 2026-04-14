package com.example.jobsapp.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {

    Column(Modifier.padding(20.dp)) {

        Text("Login Screen")

        Button(onClick = { navController.navigate("home") }) {
            Text("Login")
        }

        Button(onClick = { navController.navigate("admin") }) {
            Text("Go Admin")
        }
    }
}