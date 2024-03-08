package com.example.rentcar.ui.di

import com.example.rentcar.networking.APIClient
import com.example.rentcar.networking.ApiInterface
import com.example.rentcar.ui.response.CarListResponseModel
import javax.inject.Inject

class CarListRepository @Inject constructor (var apiClient: APIClient):ICarListRepository {
    override suspend fun getCarListData(): CarListResponseModel {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getCarListData()
    }
}