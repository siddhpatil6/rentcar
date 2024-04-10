package com.example.rentcar.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginDetailModel(
    val email: String,
    val password: String
): Parcelable