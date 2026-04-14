package com.example.jobsapp.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SignupScreen(navController: NavHostController) {

    Column(Modifier.padding(20.dp)) {

        Text("Signup Screen")

        Button(onClick = { navController.navigate("login") }) {
            Text("Back to Login")
        }
    }
}