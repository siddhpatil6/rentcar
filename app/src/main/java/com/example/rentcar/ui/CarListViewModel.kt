package com.example.rentcar.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentcar.ui.di.CarListUseCase
import com.example.rentcar.ui.models.AddOrderRequestModel
import com.example.rentcar.ui.models.CarListResponseModel
import com.example.rentcar.ui.models.LoginDetailModel
import com.example.rentcar.ui.models.OrderListRequestModel
import com.example.rentcar.ui.models.OrderListResponseModel
import com.example.rentcar.ui.models.OrderResponseModel
import com.example.rentcar.ui.models.ProfileResponseModel
import com.example.rentcar.ui.models.UserDetailModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarListViewModel @Inject constructor(private val carListUseCase: CarListUseCase):ViewModel() , LifecycleObserver {

    var carListLiveData = MutableLiveData<CarListResponseModel>()
    var loginResponseLiveData = MutableLiveData<ProfileResponseModel>()
    var signupResponseLiveData = MutableLiveData<ProfileResponseModel>()
    var orderReponseLiveData = MutableLiveData<OrderResponseModel>()
    var orderListReponseLiveData = MutableLiveData<OrderListResponseModel>()

    var userDetailLiveData= MutableLiveData<UserDetailModel>()

    fun getCarListData(){
        viewModelScope.launch {
            val data = carListUseCase.getCarListData()
            carListLiveData.postValue(data)
        }

    }

    fun getLogin(loginDetailModel: LoginDetailModel){
        viewModelScope.launch {
            val data = carListUseCase.getLogin(loginDetailModel = loginDetailModel)
            loginResponseLiveData.postValue(data)
        }
    }

    fun setSignup(userDetailModel: UserDetailModel){
        viewModelScope.launch {
            val data = carListUseCase.setSignUp(userDetailModel)
            signupResponseLiveData.postValue(data)
        }
    }

    fun addCarBookingOrder(addCarBookingOrder:AddOrderRequestModel){
        viewModelScope.launch {
            val data = carListUseCase.addCarBookingOrder(addCarBookingOrder)
            orderReponseLiveData.postValue(data)
        }
    }


    fun getProfileData(userId:String) {
        viewModelScope.launch {
            val data = carListUseCase.getProfileData(userId)
            userDetailLiveData.postValue(data)
        }
    }

    fun getCarBookingList(orderListRequestModel:OrderListRequestModel){
        viewModelScope.launch {
            val data = carListUseCase.getOrderList(orderListRequestModel)
            orderListReponseLiveData.postValue(data)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}