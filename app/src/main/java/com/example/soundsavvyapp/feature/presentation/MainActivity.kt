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

class MainActivity : ComponentActivity(), RankingCase.View {

    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setContent {
            SoundSavvyAppTheme {
                MainScreen()
                viewModel.findRanking("art", "week", 10)
                showRanking()
            }
        }

    }


    override fun showRanking() {
        viewModel.ranking.observe(this, Observer { list ->
            Toast.makeText(this, "Ebaaaaa, bati na api", Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer { visible ->

        })

        viewModel.error.observe(this, Observer { throwable ->

        })
    }

    @Preview
    @Composable
    fun preview() {
        MainScreen()
    }
}
