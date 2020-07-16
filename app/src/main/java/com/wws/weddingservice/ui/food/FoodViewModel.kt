package com.wws.weddingservice.ui.food

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wws.weddingservice.api.Api
import com.wws.weddingservice.ui.hall.Hall
import com.wws.weddingservice.ui.hall.HallListItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodViewModel : ViewModel() {
    //variable
    var foodViewModel: MutableLiveData<List<Food>> = MutableLiveData()

    //getter
    fun getFood(): MutableLiveData<List<Food>> = foodViewModel

    //setter
    var api = Api()
    fun loadingFood(resultData: String) {

        if (resultData == "Food") {
            Log.d("Type", resultData)
            var apiCall = api.getFood()

            apiCall.enqueue(object : Callback<FoodItem> {
                override fun onFailure(call: Call<FoodItem>, t: Throwable) {
                    Log.d("Error", t.toString())
                }

                override fun onResponse(call: Call<FoodItem>, response: Response<FoodItem>) {
                    Log.d("FoodList", response.body()!!.foods.toString());
                    var foodResponse: List<Food> = response.body()?.foods ?: emptyList()
                    foodViewModel.value = foodResponse

                }
            })
        }
    }
}