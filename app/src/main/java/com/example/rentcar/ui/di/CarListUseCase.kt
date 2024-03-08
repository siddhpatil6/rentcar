package com.example.rentcar.ui.di

import com.example.rentcar.ui.response.CarListResponseModel
import javax.inject.Inject

class CarListUseCase @Inject constructor(private val carListRepository:CarListRepository) :ICarListUseCase{
    override suspend fun getCarListData():CarListResponseModel {
        return carListRepository.getCarListData()
    }
}