package com.example.soundsavvyapp.common

import com.example.soundsavvyapp.R
import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.presentation.screens.home.components.model.MusicDetails

fun List<All>.toDomain(): List<MusicDetails> {
    return map {
        MusicDetails(
            id = it.id.toInt(),
            title= it.name,
            genre=it.rank,
            description= it.uniques,
            ImageId= R.drawable.ic_test
        )
    }
}