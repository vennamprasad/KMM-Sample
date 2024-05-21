package com.techbytes.kmm

import AndroidApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : ComponentActivity() {
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val users = viewModel.users.collectAsStateWithLifecycle(this)
           AndroidApp(users.value)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AndroidApp(emptyList())
}