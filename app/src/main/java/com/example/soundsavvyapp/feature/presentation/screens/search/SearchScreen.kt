package com.example.soundsavvyapp.feature.presentation.screens.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.soundsavvyapp.feature.presentation.components.SearchBar

@Composable
fun SearchScreen(navController: NavController) {
    SearchBar(enabled = true, navController = navController)
}
