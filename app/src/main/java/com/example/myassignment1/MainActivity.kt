package com.example.myassignment1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
                        }
                    )
                }
            }
        }

@Composable
fun MainScreen(onExplicitStart: () -> Unit, onImplicitStart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = "Full Name: Quinn Johnson")
        Text(text = "Student ID: 1343160")
        Button(onClick = onExplicitStart) {
            Text("Start Activity Explicitly")
        }
        Button(onClick = onImplicitStart) {
            Text("Start Activity Implicitly")
        }
    }
}

