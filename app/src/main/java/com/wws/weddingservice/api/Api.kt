package com.wws.weddingservice.api

import com.wws.weddingservice.ui.food.FoodItem
import com.wws.weddingservice.ui.hall.HallListItem
import com.wws.weddingservice.ui.packages.PackageListItem
import com.wws.weddingservice.ui.packages.Service
import com.wws.weddingservice.ui.service.ServiceListItem

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    private val apiInterface : ApiInterface

    companion object{
        val BASE_URL = "https://wedding-service.khaingthinkyi.me/api/setup/"

    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)  //create apiInterface to get data

    }

    fun getPackage():Call<PackageListItem> = apiInterface.getPackage()
    fun getService():Call<ServiceListItem> = apiInterface.getService()
    fun getFood():Call<FoodItem> = apiInterface.getFood()
    fun getHall():Call<HallListItem> = apiInterface.getHall()
}