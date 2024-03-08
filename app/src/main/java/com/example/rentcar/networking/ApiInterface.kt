package com.example.rentcar.networking

import com.example.rentcar.ui.response.CarListResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {
    @GET("/")
    suspend fun getCarListData(): CarListResponseModel
}