package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.example.soundsavvyapp.common.constants.SoundSavvyConstants
import com.example.soundsavvyapp.feature.presentation.navigation.Routes
import com.example.soundsavvyapp.feature.presentation.screens.home.components.Banner
import com.example.soundsavvyapp.feature.presentation.screens.home.components.CardItem
import com.example.soundsavvyapp.feature.presentation.screens.home.components.EmployeeCard
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

    viewModel.getRankingArt()
    viewModel.getRankingMusic()

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

            EmployeeCard(emp = it)
        }
    }

    if (stateArt.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    if (stateArt.error.isNotBlank()) {
        isDisplayDialog = true
    }


    if (isDisplayDialog) {
        Dialog(onDismissRequest = { isDisplayDialog = false }) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(15))
                    .size(400.dp)
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(text = SoundSavvyConstants.ERROR.UNKNOWN_ERROR)
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = { }) {
                    Text(text = "Concordar")

                }

            }
        }
    }

}

