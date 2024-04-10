package com.example.rentcar.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val __v: Int,
    val _id: String,
    val carImages: List<String>,
    val carName: String,
    val details: String,
    val price: String,
    val seats: String,
    val type: String
):Parcelable