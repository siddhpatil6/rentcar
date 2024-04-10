package com.example.rentcar.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class CarListResponseModel(
    val msg: String,
    val result: List<Result>
):Parcelable