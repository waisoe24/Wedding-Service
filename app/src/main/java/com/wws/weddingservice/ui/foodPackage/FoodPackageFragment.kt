package com.wws.weddingservice.ui.foodPackage

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wws.weddingservice.R

class FoodPackageFragment : Fragment() {

    companion object {
        fun newInstance() = FoodPackageFragment()
    }

    private lateinit var viewModel: FoodPackageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.food_package_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FoodPackageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}