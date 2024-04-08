package com.example.soundsavvyapp.feature.presentation.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import com.example.soundsavvyapp.feature.data.local.Favorite
import com.example.soundsavvyapp.feature.presentation.screens.home.HomeViewModel

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val favorites by viewModel.favoritesLiveData.observeAsState(initial = emptyList())
    FavoritesList(favorites = favorites)
}


@Composable
fun FavoritesList(favorites: List<Favorite>) {
    LazyColumn {
        items(favorites) { favorite ->
            FavoriteItem(favorite)
        }
    }
}

@Composable
fun FavoriteItem(favorite: Favorite) {
    Text(text = "Música: ${favorite.music}, Artista: ${favorite.art}")
    // Personalize conforme necessário.
}

@Composable
@Preview
fun SettingsScreenPreview() {
    FavoritesScreen()
}