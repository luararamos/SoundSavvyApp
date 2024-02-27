package com.example.soundsavvyapp.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.soundsavvyapp.common.constants.SoundSavvyConstants.ERROR.UNKNOWN_ERROR
import com.example.soundsavvyapp.feature.presentation.navigation.MainScreen
import com.example.soundsavvyapp.feature.presentation.screens.home.HomeViewModel
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
