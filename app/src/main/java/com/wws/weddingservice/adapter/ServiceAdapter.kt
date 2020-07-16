package com.wws.weddingservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wws.weddingservice.R
import com.wws.weddingservice.ui.food.Food
import com.wws.weddingservice.ui.packages.Package
import com.wws.weddingservice.ui.packages.PackageFragment
import com.wws.weddingservice.ui.packages.Service
import com.wws.weddingservice.ui.service.ServiceFragment
import com.wws.weddingservice.ui.service.ServiceListItem
import kotlinx.android.synthetic.main.item_service.view.*

class ServiceAdapter(var serviceList: List<Service> = ArrayList()):RecyclerView.Adapter<ServiceAdapter.serviceViewHolder>() {
    private var clickListener: ServiceAdapter.ClickerListener? = null
    fun setOnClickListener(clickListener: ServiceFragment) {
        this.clickListener = clickListener
    }
    inner class serviceViewHolder(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener {

        private lateinit var serviceItem: Service

        fun bindService(serviceItem: Service) {
            this.serviceItem = serviceItem
            itemView.serviceName.text = serviceItem.name

        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener?.onServiceClick(serviceItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): serviceViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false)
        return serviceViewHolder(view)

    }

    override fun getItemCount(): Int = serviceList.size

    override fun onBindViewHolder(holder: serviceViewHolder, position: Int) {
        holder.bindService(serviceList[position])
    }
    fun updateList(serviceList: List<Service>){
        this.serviceList = serviceList
        notifyDataSetChanged()
    }
    interface ClickerListener {
        fun onServiceClick(serviceList: Service)
    }
}