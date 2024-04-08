package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.soundsavvyapp.R
import com.example.soundsavvyapp.common.constants.SoundSavvyConstants
import com.example.soundsavvyapp.feature.presentation.navigation.Routes
import com.example.soundsavvyapp.feature.presentation.screens.home.components.Banner
import com.example.soundsavvyapp.feature.presentation.screens.home.components.CardItem
import com.example.soundsavvyapp.feature.presentation.screens.home.components.MusicCard
import com.example.soundsavvyapp.feature.presentation.screens.home.components.SearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val stateArt = viewModel.state.value
    val stateMusic = viewModel.stateMusic.value
    val employees = stateMusic.value
    var isDisplayDialog by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            SearchBar(
                enabled = false,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.Search.route)
                },
                navController = navController
            )
        }
        item {
            Banner()
        }
        item {
            Text(
                modifier = modifier.padding(horizontal = 24.dp),
                text = "Top Artistas",
                fontSize = 16.sp,
            )


        }
        item {
            if (stateArt.isLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }

            LazyRow(Modifier.padding(vertical = 16.dp)) {
                items(stateArt.value) { all ->
                    CardItem(
                        all
                    )
                }
            }
        }
        item {
            Text(
                modifier = modifier.padding(horizontal = 24.dp),
                text = "Top Músicas",
                fontSize = 16.sp,
            )
        }

        items(
            employees
        ) {
            if (stateArt.isLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }

            }
            MusicCard(emp = it)
        }
    }

    if (stateArt.error.isNotBlank() or stateMusic.error.isNotBlank()) {
        isDisplayDialog = true
    }

    if (isDisplayDialog) {
        Dialog(onDismissRequest = { isDisplayDialog = false }) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(15))
                    .size(300.dp)
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_error),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = SoundSavvyConstants.ERROR.UNKNOWN_ERROR)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "${stateArt.error} ${stateMusic.error} ")
                Spacer(modifier = Modifier.size(16.dp))
                Row() {
                    Button(onClick = { isDisplayDialog = false }) {
                        Text(text = "Cancelar")
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Button(onClick = {
                        viewModel.getRankingArt()
                        viewModel.getRankingMusic()
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }

}

