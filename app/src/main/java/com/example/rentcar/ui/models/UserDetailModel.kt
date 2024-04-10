package com.example.rentcar.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDetailModel(
    val email: String,
    val name: String,
    val password: String,
    val phone: String,
):Parcelable