package com.example.rentcar.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderResponseModel(
    val msg: String,
    val result: ResultX
):Parcelable