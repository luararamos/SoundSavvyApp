package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.soundsavvyapp.common.toDomain
import com.example.soundsavvyapp.feature.presentation.screens.home.components.Banner
import com.example.soundsavvyapp.feature.presentation.screens.home.components.CardItem
import com.example.soundsavvyapp.feature.presentation.screens.home.components.EmployeeCard
import com.example.soundsavvyapp.feature.presentation.screens.home.components.SearchBar
import com.example.soundsavvyapp.feature.presentation.screens.home.components.dados_mokados.Details

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    loginViewModel: HomeViewModel = hiltViewModel()
) {
    loginViewModel.getRanking("art", "week", 10)
    val state = loginViewModel.state.value

    val employees = remember { state.ranking.toDomain() }
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
                items(state.ranking) { all ->
                    CardItem(
                        all
                    )
                }
            }
        }
        item {
            Text(
                modifier = modifier.padding(horizontal = 24.dp),
                text = "Mais Vistas",
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