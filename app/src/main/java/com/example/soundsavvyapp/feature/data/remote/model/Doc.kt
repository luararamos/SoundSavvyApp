package com.example.soundsavvyapp.feature.data.remote.model

data class Doc(
    val band: String,
    val fmRadios: List<String>,
    val id: String,
    val langID: Int,
    val title: String,
    val url: String
)