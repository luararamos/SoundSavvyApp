package com.example.soundsavvyapp.feature.presentation.screens.home

import com.example.soundsavvyapp.feature.data.remote.model.All

data class HomeState(
    val ranking: List<All> = emptyList()
)