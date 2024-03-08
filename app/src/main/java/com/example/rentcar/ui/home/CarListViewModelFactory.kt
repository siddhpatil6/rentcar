package com.example.rentcar.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.di.CarListUseCase
import com.example.rentcar.ui.di.components.DaggerCarListComponent
import com.google.gson.Gson
import javax.inject.Inject

class CarListViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var carListUseCase: CarListUseCase


    init {
        DaggerCarListComponent.builder().build().inject(this)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarListViewModel::class.java)) {
            return CarListViewModel(carListUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}