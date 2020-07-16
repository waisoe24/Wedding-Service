package com.wws.weddingservice.ui.service

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wws.weddingservice.api.Api
import com.wws.weddingservice.ui.packages.PackageListItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceViewModel : ViewModel() {

    //variable
    var serviceViewModel: MutableLiveData<ServiceListItem> = MutableLiveData()

    //getter
    fun getService(): MutableLiveData<ServiceListItem> = serviceViewModel

    //setter
    var api = Api()
    fun loadingService(){

        var apiCall = api.getService()

        apiCall.enqueue(object: Callback<ServiceListItem> {
            override fun onFailure(call: Call<ServiceListItem>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ServiceListItem>,
                response: Response<ServiceListItem>
            ) {
               var serviceResponse = response.body()
                serviceViewModel.value = serviceResponse
            }
        })
    }
}