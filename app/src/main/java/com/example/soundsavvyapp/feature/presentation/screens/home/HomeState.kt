package com.example.soundsavvyapp.feature.presentation.screens.home

import com.example.soundsavvyapp.feature.data.remote.model.All

data class HomeState<T>(
    val isLoading: Boolean = false,
    val value: List<T> = emptyList(),
    val error: String = ""
)