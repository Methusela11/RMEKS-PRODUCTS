package com.example.jobsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import androidx.navigation.NavHostController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobApp()
        }
    }
}

@Composable
fun JobApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {

        composable("welcome") {
            WelcomeScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("signup") {
            SignupScreen(navController)
        }

        composable("home") {
            HomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {

    val pages = listOf(
        Triple("Jobs", "Find your dream job based on your skills.", R.drawable.job),
        Triple("Internship", "Kickstart your career with real experience.", R.drawable.internship),
        Triple("Attachment", "Gain practical exposure in your field.", R.drawable.attachment)
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            val nextPage = (pagerState.currentPage + 1) % pages.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))
            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .padding(20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(Color(0xFFF5F5F5))
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.weight(1f)
                    ) { page ->

                        val (title, desc, image) = pages[page]

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(id = image),
                                contentDescription = null,
                                modifier = Modifier.size(180.dp)
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 26.sp
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = desc,
                                fontSize = 15.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row {
                            repeat(pages.size) { index ->
                                Box(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .size(
                                            if (pagerState.currentPage == index) 10.dp else 8.dp
                                        )
                                        .background(
                                            if (pagerState.currentPage == index)
                                                Color(0xFF19B09F)
                                            else Color.Gray,
                                            shape = CircleShape
                                        )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = {
                                navController.navigate("login")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF19B09F)
                            )
                        ) {
                            Text(
                                text = "Explore",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(20.dp)) {

        Text("Login Screen")

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate("home")
        }) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate("signup")
        }) {
            Text("Go to Signup")
        }
    }
}

@Composable
fun SignupScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(20.dp)) {

        Text("Signup Screen")

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate("login")
        }) {
            Text("Back to Login")
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text("Job Listings Screen")
    }
}