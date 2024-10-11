package com.example.myassignment1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                onExplicitStart = {
                    val intent = Intent(this, ChallengesActivity::class.java)
                    startActivity(intent)
                },
                onImplicitStart = {
                    val intent = Intent("com.example.myassignment1.CHALLENGES")
                    intent.addCategory(Intent.CATEGORY_DEFAULT)
                    startActivity(intent)
                },
                onViewImageActivity = {
                    val intent = Intent(this, ImageActivity::class.java)
                    startActivity(intent)
                }
            )
        }
    }
}

@Composable
fun MainScreen(
    onExplicitStart: () -> Unit,
    onImplicitStart: () -> Unit,
    onViewImageActivity: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Student Information",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(text = "Full Name: Quinn Johnson")
                        Text(text = "Student ID: 1343160")
                    }
                    Button(
                        onClick = onExplicitStart,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text("Start Activity Explicitly")
                    }
                    Button(
                        onClick = onImplicitStart,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text("Start Activity Implicitly")
                    }
                    Button(
                        onClick = onViewImageActivity,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text("View Image Activity")
                    }
                }
            }
        }
    }
}