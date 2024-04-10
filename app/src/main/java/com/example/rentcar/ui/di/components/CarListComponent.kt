package com.example.rentcar.ui.di.components

import com.example.rentcar.ui.di.modules.AppModule
import com.example.rentcar.ui.di.modules.CarListModule
import com.example.rentcar.ui.fragment.CarListFragment
import com.example.rentcar.ui.fragment.HomeFragment
import com.example.rentcar.ui.home.CarListViewModelFactory
import dagger.Component


@Component(modules = [AppModule::class, CarListModule::class])
interface CarListComponent {

    fun inject(homeFragment: HomeFragment)

    fun inject(homeFragment: CarListFragment)

    fun inject(carListViewModelFactory: CarListViewModelFactory)

}