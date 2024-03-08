package com.example.rentcar.ui.di.provider

import com.example.rentcar.ui.di.components.CarListComponent
import com.example.rentcar.ui.di.components.DaggerCarListComponent

object CarListComponentProvider {

    private lateinit var carListComponent : CarListComponent

    fun getCarListComponent(): CarListComponent {
        if (CarListComponentProvider::carListComponent.isInitialized.not()) {
            carListComponent = DaggerCarListComponent.builder()
                .build()
        }
        return carListComponent
    }
}