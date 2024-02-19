package com.example.soundsavvyapp.feature.presentation.screens.home.components.model

import androidx.compose.ui.graphics.Brush

data class MusicDetails(
                        val name: String,
                        val artist: String,
                        val ranking: String,
                        val image: String,
                        val color: Brush
                        )
