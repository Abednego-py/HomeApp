package com.example.homeapp.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @NonNull
    val use: String,
    @NonNull
    val title: String,
    @NonNull
    val time: String
)
