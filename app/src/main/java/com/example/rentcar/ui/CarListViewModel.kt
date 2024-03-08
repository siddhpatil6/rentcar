package com.example.rentcar.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentcar.ui.di.CarListUseCase
import com.example.rentcar.ui.response.CarListResponseModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarListViewModel @Inject constructor(private val carListUseCase: CarListUseCase):ViewModel() , LifecycleObserver {

    var carListLiveData = MutableLiveData<CarListResponseModel>()
     fun getCarListData(){
        viewModelScope.launch {
            val data = carListUseCase.getCarListData()
            carListLiveData.postValue(data)
        }

    }

    override fun onCleared() {
        super.onCleared()
    }
}