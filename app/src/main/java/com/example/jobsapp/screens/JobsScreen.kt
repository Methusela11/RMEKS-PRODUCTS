package com.example.jobsapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.example.jobsapp.model.Job

@Composable
fun JobsScreen() {

    val db = FirebaseFirestore.getInstance()
    val jobs = remember { mutableStateListOf<Job>() }

    LaunchedEffect(Unit) {
        db.collection("jobs").addSnapshotListener { snap, _ ->
            jobs.clear()
            snap?.documents?.forEach {
                it.toObject(Job::class.java)?.let { job -> jobs.add(job) }
            }
        }
    }

    Column(Modifier.padding(16.dp)) {

        Text("Available Jobs")


        jobs.forEach {
            Card(Modifier.fillMaxWidth().padding(8.dp)) {
                Column(Modifier.padding(10.dp)) {
                    Text(it.title)
                    Text(it.company)
                    Text(it.location)
                }
            }
        }
    }
}