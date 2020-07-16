package com.wws.weddingservice.ui.food

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.wws.weddingservice.R
import com.wws.weddingservice.adapter.FoodAdapter
import com.wws.weddingservice.adapter.HallAdapter
import com.wws.weddingservice.ui.hall.Hall
import com.wws.weddingservice.ui.hall.HallClick
import com.wws.weddingservice.ui.hall.HallViewModel
import kotlinx.android.synthetic.main.food_fragment.*

class FoodFragment : Fragment(), FoodClick, HallClick{
    private lateinit var foodViewModel: FoodViewModel
    private lateinit var hallViewModel: HallViewModel
    private lateinit var foodAdapter: FoodAdapter
   private lateinit var hallAdapter: HallAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.food_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var  data = arguments.let { FoodFragmentArgs.fromBundle(it!!) }

        var resultData = data.foodName
        if (resultData=="Food"){

            recFood.layoutManager=GridLayoutManager(context,2)
            foodAdapter= FoodAdapter(this)
            recFood.adapter=foodAdapter
        }
        if (resultData=="Hall"){
            requireActivity().actionBar?.title="Hall"

            recFood.layoutManager=GridLayoutManager(context,2)
            hallAdapter= HallAdapter(this)
            recFood.adapter=hallAdapter
        }
        observerViewModel(resultData)
    }

    fun observerViewModel(type: String){

        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        hallViewModel = ViewModelProvider(this).get(HallViewModel::class.java)

        if (type == "Food"){
            foodViewModel.loadingFood(type)
            foodViewModel.getFood().observe(viewLifecycleOwner, Observer {

                Log.d("updateList",it.toString())
                foodAdapter.updateList(it)

            })
        }

        if (type == "Hall")
        {
            hallViewModel.loadingHall(type)
            hallViewModel.getHall().observe(viewLifecycleOwner, Observer {
                Log.d("rrrrr>>>>>>>",it.toString())
                hallAdapter.updateList(it)

            })
        }
    }

    override fun onResume() {
        super.onResume()
        var  data = arguments.let { FoodFragmentArgs.fromBundle(it!!) }
        var resultData = data.foodName
        Log.d("name>>>>>>>",resultData)

    }

    override fun onFoodDetailClick(f: Food) {
       var action = FoodFragmentDirections.actionNavFoodToFoodDetailFragment(f)
        findNavController().navigate(action)
    }

    override fun onHallDetailClick(h: Hall) {
        Toast.makeText(context,h.name,Toast.LENGTH_LONG).show()
        var action = FoodFragmentDirections.actionNavFoodToHallDetailFragment(h)
        findNavController().navigate(action)
    }
}