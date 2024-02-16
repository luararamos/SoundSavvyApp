package com.example.soundsavvyapp.common

import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.presentation.screens.home.components.model.MusicDetails

fun List<All>.toDomain(): List<MusicDetails> {
    return map {
        MusicDetails(
            name = it.name,
            artist = it.art?.name ?: "",
            ranking = it.rank,
            image = it.art?.pic_medium ?: ""
        )
    }
}