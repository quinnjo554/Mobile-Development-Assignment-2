package com.example.myassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ChallengesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    ChallengesScreen(
                        onMainActivityClick = {
                            finish()
                        }
                    )
                }
            }
        }

@Composable
fun ChallengesScreen(onMainActivityClick: () -> Unit) {
    val challenges = listOf(
        "Security and Privacy",
        "Performance Optimization",
        "Cross-platform Development",
        "User Interface Design",
        "Battery Life Management"
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Mobile Software Engineering Challenges"
        )
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(challenges) { challenge ->
                Text(
                    text = "• $challenge",
                )
            }
        }
        Button(
            onClick = onMainActivityClick
        ) {
            Text("Main Activity")
        }
    }
}