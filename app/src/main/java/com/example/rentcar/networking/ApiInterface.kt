package com.example.rentcar.networking

import com.example.rentcar.ui.models.AddOrderRequestModel
import com.example.rentcar.ui.models.CarListResponseModel
import com.example.rentcar.ui.models.LoginDetailModel
import com.example.rentcar.ui.models.OrderListRequestModel
import com.example.rentcar.ui.models.OrderListResponseModel
import com.example.rentcar.ui.models.OrderResponseModel
import com.example.rentcar.ui.models.ProfileResponseModel
import com.example.rentcar.ui.models.UserDetailModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("cars/showCars")
    suspend fun getCarListData(): CarListResponseModel

    @POST("users/login")
    suspend fun getLogin(@Body loginDetailModel: LoginDetailModel): ProfileResponseModel

    @POST("users/addUser")
    suspend fun setSignUp(@Body userDetailModel: UserDetailModel): ProfileResponseModel


    @GET("/")
    suspend fun getProfileDetail(id:String): UserDetailModel

    @POST("orders/showOrderByUserId")
    suspend fun getOrderList(@Body orderListRequestModel: OrderListRequestModel): OrderListResponseModel

    @POST("orders/addOrder")
    suspend fun addCarBookingOrder(@Body addOrderRequestModel: AddOrderRequestModel): OrderResponseModel


}