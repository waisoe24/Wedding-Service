package com.wws.weddingservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wws.weddingservice.R
import com.wws.weddingservice.ui.food.FoodFragment
import com.wws.weddingservice.ui.hall.Hall
import com.wws.weddingservice.ui.hall.HallClick
import com.wws.weddingservice.ui.hall.HallFragment
import kotlinx.android.synthetic.main.item_food.view.*
import kotlinx.android.synthetic.main.item_hall.view.*

class HallAdapter(var hc: HallClick): RecyclerView.Adapter<HallAdapter.hallViewHolder>() {
    var hallList:List<Hall> = listOf()
    inner class hallViewHolder(item: View) : RecyclerView.ViewHolder(item) {


        fun bindHall(hallItem: Hall) {

            Picasso.get()
                .load("https://wedding-service.khaingthinkyi.me/" + hallItem.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.hallImage)
            itemView.hallName.text = hallItem.name
            itemView.cardHall.setOnClickListener{
                hc.onHallDetailClick(hallItem)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hallViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_hall, parent, false)
        return hallViewHolder(view)
    }

    override fun getItemCount(): Int = hallList.size

    override fun onBindViewHolder(holder: hallViewHolder, position: Int) {
        holder.bindHall(hallList[position])
    }
    fun updateList(hallList: List<Hall>){
        this.hallList = hallList
        notifyDataSetChanged()
    }

}