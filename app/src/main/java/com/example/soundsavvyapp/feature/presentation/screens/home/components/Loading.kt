package com.example.soundsavvyapp.feature.presentation.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier

@Composable
fun RakingListScreen (uiState: RankingListUiState) {
    val isLoading = uiState.isLoading
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Center))
        }
    } else {
        LazyColumn(Modifier.fillMaxSize()) {

        }
    }
}