package com.example.rentcar.ui.models

data class AddOrderRequestModel(
    val car_id: String,
    val date: String,
    val order_prize: String,
    val time: String,
    val user_id: String
)