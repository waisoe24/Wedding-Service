package com.wws.weddingservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wws.weddingservice.R
import com.wws.weddingservice.ui.packages.Package
import com.wws.weddingservice.ui.packages.PackageFragment
import com.wws.weddingservice.ui.packages.PackageListItem
import com.wws.weddingservice.ui.packages.Service
import kotlinx.android.synthetic.main.item_package.view.*
import kotlinx.android.synthetic.main.item_package.view.*

class PackageAdapter(var packageList: List<Package> = ArrayList()):RecyclerView.Adapter<PackageAdapter.packageViewHolder>(){
    private var clickListener: ClickerListener ? = null
    fun setOnClickListener(clickListener: PackageFragment) {
        this.clickListener = clickListener
    }
    inner class packageViewHolder(item: View): RecyclerView.ViewHolder(item), View.OnClickListener{

        private lateinit var packageItem: Package

        fun bindPackage(packageItem: Package){
            this.packageItem = packageItem
            itemView.packageName.text =packageItem.name

        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener?.onPackageClick(packageItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): packageViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_package, parent, false)
        return packageViewHolder(view)
    }

    override fun getItemCount(): Int = packageList.size

    override fun onBindViewHolder(holder: packageViewHolder, position: Int) {
        holder.bindPackage(packageList[position])
    }

    fun updateList(packageList: List<Package>){
        this.packageList = packageList
        notifyDataSetChanged()
    }
    interface ClickerListener {
        fun onPackageClick(packageList: Package)
    }
}