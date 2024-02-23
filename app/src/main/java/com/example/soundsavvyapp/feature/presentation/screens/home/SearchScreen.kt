package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.soundsavvyapp.feature.presentation.screens.home.components.SearchBar

@Composable
fun SearchScreen(navController: NavController) {
    SearchBar(enabled = true, navController = navController)
}
