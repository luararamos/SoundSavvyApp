package com.example.soundsavvyapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.soundsavvyapp.view.screns.RankingListUiState
import com.example.soundsavvyapp.view.theme.SoundSavvyAppTheme
import com.example.soundsavvyapp.viewmodel.RankingViewModel

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
    fun preview(){
        MainScreen()
    }
}
