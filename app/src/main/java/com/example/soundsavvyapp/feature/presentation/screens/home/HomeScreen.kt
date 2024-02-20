package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.soundsavvyapp.feature.presentation.screens.home.components.Banner
import com.example.soundsavvyapp.feature.presentation.screens.home.components.CardItem
import com.example.soundsavvyapp.feature.presentation.screens.home.components.EmployeeCard
import com.example.soundsavvyapp.feature.presentation.screens.home.components.SearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel.getRankingArt()
    viewModel.getRankingMusic()
    val state = viewModel.state.value
    val stateMusic = viewModel.stateMusic.value

    val employees = stateMusic.value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            SearchBar()
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
                items(state.value) { all ->
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
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}