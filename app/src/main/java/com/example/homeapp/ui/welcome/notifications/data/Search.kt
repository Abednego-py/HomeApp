package com.example.homeapp.ui.welcome.notifications.data

import androidx.annotation.NonNull
import androidx.room.PrimaryKey


data class Search(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @NonNull val SearchText: String
)
