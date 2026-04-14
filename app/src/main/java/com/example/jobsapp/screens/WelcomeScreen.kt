package com.example.jobsapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import com.example.jobsapp.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavHostController) {

    val pages = listOf(
        Triple("Jobs", "Find your dream job.", R.drawable.job),
        Triple("Internship", "Kickstart your career.", R.drawable.internship),
        Triple("Attachment", "Gain experience.", R.drawable.attachment)
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % pages.size)
        }
    }

    Box(Modifier.fillMaxSize().background(Color.Black)) {

        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(Modifier.height(50.dp))
            Spacer(Modifier.weight(1f))

            Card(
                Modifier.fillMaxWidth().fillMaxHeight(0.7f).padding(20.dp),
                shape = RoundedCornerShape(30.dp)
            ) {

                Column(Modifier.padding(24.dp)) {

                    HorizontalPager(state = pagerState) { page: Int ->

                        val (title, desc, image) = pages[page]

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Image(painterResource(image), null, Modifier.size(180.dp))

                            Text(title, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                            Text(desc, fontSize = 15.sp)
                        }
                    }

                    Button(
                        onClick = { navController.navigate("login") },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Explore")
                    }
                }
            }
        }
    }
}