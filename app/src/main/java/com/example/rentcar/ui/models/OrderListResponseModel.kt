package com.example.rentcar.ui.models

data class OrderListResponseModel(
    val msg: String,
    val orders: List<Order>
)