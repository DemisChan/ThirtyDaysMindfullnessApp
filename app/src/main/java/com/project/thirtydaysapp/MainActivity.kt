package com.project.thirtydaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.thirtydaysapp.data.ActivityRepository
import com.project.thirtydaysapp.ui.theme.ThirtyDaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MidfulnessApp()
                }
            }
        }
    }
}

@Composable
fun MidfulnessApp() {
    Scaffold(
        topBar = { MindfulnessTopAppbar() },
    ) {
        ActivityList(
            activityList = ActivityRepository.activities,
            contentPadding = it
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MindfulnessTopAppbar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 Day Mindfulness Challenge",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 20.sp
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MidfulnessAppPreview() {
    ThirtyDaysAppTheme {
        MidfulnessApp()
    }
}