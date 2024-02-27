package com.example.soundsavvyapp.feature.data.remote.model

data class Response(
    val docs: List<Doc>,
    val numFound: Int,
    val numFoundExact: Boolean,
    val start: Int
)