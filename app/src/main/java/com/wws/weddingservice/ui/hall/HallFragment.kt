package com.wws.weddingservice.ui.hall

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.wws.weddingservice.R
import com.wws.weddingservice.adapter.FoodAdapter
import com.wws.weddingservice.adapter.HallAdapter
import com.wws.weddingservice.ui.food.FoodFragmentArgs
import com.wws.weddingservice.ui.food.FoodFragmentDirections
import com.wws.weddingservice.ui.food.FoodViewModel
import kotlinx.android.synthetic.main.food_fragment.*
import kotlinx.android.synthetic.main.hall_fragment.*

class HallFragment : Fragment(){

    private lateinit var hallViewModel: HallViewModel
    private lateinit var hallAdapter: HallAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hall_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var data = arguments.let { HallFragmentArgs.fromBundle(it!!) }
        var resultData = data.hallName
        Log.d("ttt>>>>>>>",resultData)

        observerViewModel(resultData)
    }

    fun observerViewModel(type: String){

        hallViewModel = ViewModelProvider(this).get(HallViewModel::class.java)
        hallViewModel.loadingHall(type)
        hallViewModel.getHall().observe(viewLifecycleOwner, Observer {
            Log.d("rrrrr>>>>>>>",it.toString())
            hallAdapter.updateList(it)

        })
    }

    override fun onResume() {
        super.onResume()
        var  data = arguments.let { HallFragmentArgs.fromBundle(it!!) }
        var resultData = data.hallName

        Log.d("name>>>>>>>",resultData)
        var categoryName = data?.hallName
        (activity as  AppCompatActivity).supportActionBar?.title = categoryName

    }

}