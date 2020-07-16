package com.wws.weddingservice.api


import com.wws.weddingservice.ui.food.FoodItem
import com.wws.weddingservice.ui.hall.HallListItem
import com.wws.weddingservice.ui.packages.PackageListItem
import com.wws.weddingservice.ui.packages.Service
import com.wws.weddingservice.ui.service.ServiceListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @GET("package")
    fun getPackage(): Call<PackageListItem>

    @GET("service")
    fun  getService(): Call<ServiceListItem>

    @GET("food")
    fun  getFood(): Call<FoodItem>

    @GET("hall")
    fun  getHall(): Call<HallListItem>

}