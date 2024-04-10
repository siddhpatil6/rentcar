package com.example.rentcar.ui.di

import com.example.rentcar.ui.models.AddOrderRequestModel
import com.example.rentcar.ui.models.CarListResponseModel
import com.example.rentcar.ui.models.LoginDetailModel
import com.example.rentcar.ui.models.OrderListRequestModel
import com.example.rentcar.ui.models.OrderListResponseModel
import com.example.rentcar.ui.models.OrderResponseModel
import com.example.rentcar.ui.models.ProfileResponseModel
import com.example.rentcar.ui.models.UserDetailModel
import javax.inject.Inject

class CarListUseCase @Inject constructor(private val carListRepository:CarListRepository) :ICarListUseCase{
    override suspend fun getCarListData():CarListResponseModel {
        return carListRepository.getCarListData()
    }

    override suspend fun getLogin(loginDetailModel: LoginDetailModel): ProfileResponseModel {
        return carListRepository.getLogin(loginDetailModel)

    }

    override suspend fun setSignUp(userDetailModel: UserDetailModel): ProfileResponseModel {
        return carListRepository.setSignUp(userDetailModel)
    }

    override suspend fun getOrderList(orderListRequestModel: OrderListRequestModel): OrderListResponseModel {
        return carListRepository.getOrderList(orderListRequestModel)
    }

    override suspend fun addCarBookingOrder(addOrderRequestModel: AddOrderRequestModel): OrderResponseModel {
        return carListRepository.addCarBookingOrder(addOrderRequestModel)
    }

    override suspend fun getProfileData(userId:String): UserDetailModel {
        return carListRepository.getProfileData(userId)
    }


}