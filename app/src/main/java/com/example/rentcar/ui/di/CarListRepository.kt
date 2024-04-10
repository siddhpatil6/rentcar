package com.example.rentcar.ui.di

import com.example.rentcar.networking.APIClient
import com.example.rentcar.networking.ApiInterface
import com.example.rentcar.ui.models.AddOrderRequestModel
import com.example.rentcar.ui.models.CarListResponseModel
import com.example.rentcar.ui.models.LoginDetailModel
import com.example.rentcar.ui.models.OrderListRequestModel
import com.example.rentcar.ui.models.OrderListResponseModel
import com.example.rentcar.ui.models.OrderResponseModel
import com.example.rentcar.ui.models.ProfileResponseModel
import com.example.rentcar.ui.models.UserDetailModel
import javax.inject.Inject

class CarListRepository @Inject constructor (var apiClient: APIClient):ICarListRepository {
    override suspend fun getCarListData(): CarListResponseModel {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getCarListData()
    }

    override suspend fun getLogin(loginDetailModel:LoginDetailModel): ProfileResponseModel {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getLogin(loginDetailModel)
    }

    override suspend fun setSignUp(userDetailModel: UserDetailModel): ProfileResponseModel {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.setSignUp(userDetailModel)
    }

    override suspend fun getOrderList(orderListRequestModel: OrderListRequestModel): OrderListResponseModel {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getOrderList(orderListRequestModel)
    }

    override suspend fun addCarBookingOrder(addOrderRequestModel: AddOrderRequestModel): OrderResponseModel {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.addCarBookingOrder(addOrderRequestModel)
    }

    override suspend fun getProfileData(userId: String): UserDetailModel {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getProfileDetail(userId)
    }


}