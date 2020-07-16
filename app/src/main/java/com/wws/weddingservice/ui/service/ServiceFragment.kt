package com.wws.weddingservice.ui.service

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.wws.weddingservice.R
import com.wws.weddingservice.adapter.ServiceAdapter
import com.wws.weddingservice.ui.food.Food
import com.wws.weddingservice.ui.packages.Package
import com.wws.weddingservice.ui.packages.Service
import kotlinx.android.synthetic.main.fragment_service.*

class ServiceFragment : Fragment(), ServiceAdapter.ClickerListener {

    private lateinit var serviceViewModel: ServiceViewModel
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_service, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var messageArgs = arguments?.let { ServiceFragmentArgs.fromBundle(it) }
        var services: List<Service> = messageArgs?.services!!.services

        Log.d("services", services.toString());
        serviceAdapter = ServiceAdapter()
        recService.apply {
            adapter = serviceAdapter
            layoutManager = GridLayoutManager(context, 1)

        }
        serviceAdapter.updateList(services)
        serviceAdapter.setOnClickListener(this)
    }

    override fun onServiceClick(serviceList: Service) {
        var action = ServiceFragmentDirections.actionNavServiceToNavFood(serviceList.name)
        findNavController().navigate(action)

        Log.d("ServiceName>>>>>",serviceList.name)
    }

}