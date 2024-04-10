package com.example.soundsavvyapp.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.soundsavvyapp.feature.presentation.navigation.MainScreen
import com.example.soundsavvyapp.ui.theme.SoundSavvyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoundSavvyAppTheme {

                MainScreen()

            }
        }
    }

    @Preview
    @Composable
    fun preview() {
        MainScreen()
    }
}
