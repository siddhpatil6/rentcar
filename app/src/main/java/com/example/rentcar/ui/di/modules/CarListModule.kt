package com.example.rentcar.ui.di.modules

import com.example.rentcar.networking.APIClient
import com.example.rentcar.ui.di.CarListRepository
import com.example.rentcar.ui.di.CarListUseCase
import com.example.rentcar.ui.di.ICarListRepository
import com.example.rentcar.ui.di.ICarListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CarListModule {
    @Provides
    fun getCarListUseCase(carListRepository: CarListRepository): ICarListUseCase = CarListUseCase(carListRepository = carListRepository)

    @Provides
    fun getCarListRepository(apiClient: APIClient): ICarListRepository = CarListRepository(apiClient)


}