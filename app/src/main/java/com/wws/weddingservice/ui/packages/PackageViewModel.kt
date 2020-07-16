package com.wws.weddingservice.ui.packages

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wws.weddingservice.api.Api
import com.wws.weddingservice.ui.packages.PackageListItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PackageViewModel : ViewModel() {
    //variable
    var packageViewModel: MutableLiveData<PackageListItem> = MutableLiveData()

    //getter
    fun getPackage(): MutableLiveData<PackageListItem> = packageViewModel

    //setter
    var api = Api()
    fun loadingPackage(){

        var apiCall = api.getPackage()

        apiCall.enqueue(object: Callback<PackageListItem> {
            override fun onFailure(call: Call<PackageListItem>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<PackageListItem>,
                response: Response<PackageListItem>
            ) {
                var packageResponse = response.body()
                packageViewModel.value = packageResponse
                //Log.d("response>>>>", packageResponse.toString())

            }
        })
    }
}