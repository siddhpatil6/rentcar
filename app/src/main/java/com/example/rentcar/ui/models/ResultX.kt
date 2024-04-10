package com.example.rentcar.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultX(
    val __v: Int,
    val _id: String,
    val car_id: String,
    val date: String,
    val order_prize: String,
    val time: String,
    val user_id: String
):Parcelable