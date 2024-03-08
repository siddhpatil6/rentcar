package com.example.rentcar.ui.di

import com.example.rentcar.ui.response.CarListResponseModel
import retrofit2.Response

interface ICarListUseCase {
    suspend fun getCarListData(): CarListResponseModel
}