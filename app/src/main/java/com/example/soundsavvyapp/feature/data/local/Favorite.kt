package com.example.soundsavvyapp.feature.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Favorite (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "music") val music: String = "",
    @ColumnInfo(name = "art") val art: String = "",
    @ColumnInfo(name = "photo") val photo: String = ""
)