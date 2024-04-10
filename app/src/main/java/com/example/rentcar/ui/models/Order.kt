package com.example.rentcar.ui.models

data class Order(
    val __v: Int,
    val _id: String,
    val car_id: CarId,
    val date: String,
    val order_prize: String,
    val time: String,
    val user_id: String
)