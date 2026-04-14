package com.example.jobsapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AdminUploadScreen() {

    val db = FirebaseFirestore.getInstance()

    var title by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Admin Upload Job",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Job Title
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Job Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Company
        OutlinedTextField(
            value = company,
            onValueChange = { company = it },
            label = { Text("Company") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Location
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val job = hashMapOf(
                    "title" to title,
                    "company" to company,
                    "location" to location
                )

                db.collection("jobs")
                    .add(job)
                    .addOnSuccessListener {
                        // Clear fields
                        title = ""
                        company = ""
                        location = ""
                    }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Upload Job")
        }
    }
}