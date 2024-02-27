package com.example.soundsavvyapp.common

import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.presentation.screens.home.components.getGradient
import com.example.soundsavvyapp.feature.presentation.screens.home.components.model.MusicDetails
import com.example.soundsavvyapp.ui.theme.PurpleEnd
import com.example.soundsavvyapp.ui.theme.PurpleStart

fun List<All>.details(): List<MusicDetails> {
     return  map {
        MusicDetails(
            name = it.name,
            artist = it.art?.name ?: "",
            ranking = it.rank,
            image = it.art?.pic_medium ?: "",
            color =  getGradient(PurpleStart, PurpleEnd)
        )

    }

}