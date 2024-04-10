package com.example.soundsavvyapp.feature.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.soundsavvyapp.feature.presentation.screens.favorites.FavoritesScreen
import com.example.soundsavvyapp.feature.presentation.screens.home.HomeScreen
import com.example.soundsavvyapp.feature.presentation.screens.profile.ProfileScreen
import com.example.soundsavvyapp.feature.presentation.screens.search.SearchScreen



@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController =navController)
        }
        composable(route = BottomBarScreen.Favorites.route) {
            FavoritesScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Routes.Search.route) {
            SearchScreen(navController =navController)
        }

    }
}