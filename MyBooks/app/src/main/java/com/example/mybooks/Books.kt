package com.example.mybooks

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Books(
    val name :String,
    val photo :String,
    val deskripsi :String,
) : Parcelable
