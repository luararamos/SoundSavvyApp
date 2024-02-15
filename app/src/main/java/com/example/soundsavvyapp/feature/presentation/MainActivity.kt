package com.example.soundsavvyapp.feature.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.soundsavvyapp.feature.domain.RankingCase
import com.example.soundsavvyapp.feature.presentation.navigation.MainScreen
import com.example.soundsavvyapp.feature.presentation.screens.home.HomeViewModel
import com.example.soundsavvyapp.ui.theme.SoundSavvyAppTheme
import dagger.hilt.android.AndroidEntryPoint

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
