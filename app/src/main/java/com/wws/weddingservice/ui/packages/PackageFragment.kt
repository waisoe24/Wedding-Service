package com.wws.weddingservice.ui.packages

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
import com.wws.weddingservice.adapter.PackageAdapter
import kotlinx.android.synthetic.main.fragment_package.*

class PackageFragment : Fragment(), PackageAdapter.ClickerListener {

    private lateinit var packageViewModel: PackageViewModel
    private lateinit var packageAdapter: PackageAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_package, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        packageAdapter = PackageAdapter()
        recPackage.apply {
            adapter = packageAdapter
            layoutManager = GridLayoutManager(context, 1)

        }
        observerViewModel()
    }

    fun observerViewModel(){

        packageViewModel = ViewModelProvider(this).get(PackageViewModel::class.java)
        packageViewModel.loadingPackage()
        packageViewModel.getPackage().observe(viewLifecycleOwner, Observer {

            //Log.d("code>>>>",it.toString())
            packageAdapter.updateList(it.packages)
            packageAdapter.setOnClickListener(this)
        })

    }

    override fun onPackageClick(packageList: Package) {
        var action = PackageFragmentDirections.actionNavHomeToNavService(packageList)
        findNavController().navigate(action)
    }
}