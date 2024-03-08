package com.example.rentcar.ui.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Car(
    val name: String,
    val price: String,
    val seats: Int,
    val img: String
):Parcelable

@Parcelize
data class CarListResponseModel(
    val cars: List<Car>
):Parcelable