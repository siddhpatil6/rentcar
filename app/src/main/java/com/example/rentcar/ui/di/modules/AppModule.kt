package com.example.rentcar.ui.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // Use SingletonComponent or any other appropriate component
object AppModule {

    @Provides
    @JvmStatic
    fun provideGson(): Gson {
        return Gson()
    }
}
