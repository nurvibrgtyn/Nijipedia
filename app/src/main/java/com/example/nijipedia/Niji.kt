package com.example.nijipedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Niji (
    val name: String,
    val photo: Int,
    val description:String,
    val birthday: String,
    val height: String,
    val debut: String,
    val song: String,
    val album: Int,

) : Parcelable