package com.example.mynavigationapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynavigationapp.ui.theme.MyNavigationAppTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNavigationAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    DetailScreen(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    DetailScreen2(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val message = (context as? Activity)?.intent?.getStringExtra("EXTRA_MESSAGE") ?: "No message"
    Text(
        modifier = modifier,
        text = message,
    )
}

@Composable
fun DetailScreen2(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val taskId = (context as? Activity)?.intent?.getStringExtra("TASK_ID") ?: "Unknown Task"
    Text(
        modifier = modifier,
        text = "Details for Task ID: $taskId",
        style = MaterialTheme.typography.labelLarge
    )
}