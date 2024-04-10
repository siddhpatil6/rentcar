package com.example.rentcar.ui.di

import com.example.rentcar.ui.models.AddOrderRequestModel
import com.example.rentcar.ui.models.CarListResponseModel
import com.example.rentcar.ui.models.LoginDetailModel
import com.example.rentcar.ui.models.OrderListRequestModel
import com.example.rentcar.ui.models.OrderListResponseModel
import com.example.rentcar.ui.models.OrderResponseModel
import com.example.rentcar.ui.models.ProfileResponseModel
import com.example.rentcar.ui.models.UserDetailModel

interface ICarListUseCase {
    suspend fun getCarListData(): CarListResponseModel

    suspend fun getLogin(loginDetailModel: LoginDetailModel): ProfileResponseModel

    suspend fun setSignUp(userDetailModel: UserDetailModel): ProfileResponseModel

    suspend fun getOrderList(orderListRequestModel: OrderListRequestModel): OrderListResponseModel

    suspend fun addCarBookingOrder(addOrderRequestModel: AddOrderRequestModel): OrderResponseModel

    suspend fun getProfileData(userId:String): UserDetailModel


}