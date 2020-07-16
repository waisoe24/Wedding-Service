package com.wws.weddingservice.ui.hall

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wws.weddingservice.api.Api
import com.wws.weddingservice.ui.food.Food
import com.wws.weddingservice.ui.food.FoodItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HallViewModel : ViewModel() {
    var hallViewModel: MutableLiveData<List<Hall>> = MutableLiveData()

    //getter
    fun getHall(): MutableLiveData<List<Hall>> = hallViewModel
    var api = Api()
    fun loadingHall(resultData: String) {

        if (resultData == "Hall") {
            Log.d("Type", resultData)
            var apiCall = api.getHall()

            apiCall.enqueue(object : Callback<HallListItem> {
                override fun onFailure(call: Call<HallListItem>, t: Throwable) {
                    Log.d("Error", t.toString())
                }

                override fun onResponse(
                    call: Call<HallListItem>,
                    response: Response<HallListItem>
                ) {
                    Log.d("HallList", response.body()!!.halls.toString());
                    var hallResponse: List<Hall> = response.body()?.halls ?: emptyList()
                   hallViewModel.value = hallResponse
                }
            })
        }
    }
}