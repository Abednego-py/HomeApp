package com.example.homeapp.ui.welcome.home.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

//import kotlinx.android.parcel.Parcelize
//import kotlinx.parcelize.Parcelize

@Parcelize
data class Home(
    @DrawableRes val imageResourceId: Int
) : Parcelable
