package com.wws.weddingservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wws.weddingservice.R
import com.wws.weddingservice.ui.food.Food
import com.wws.weddingservice.ui.food.FoodClick
import kotlinx.android.synthetic.main.item_food.view.*

class FoodAdapter(var fc: FoodClick): RecyclerView.Adapter<FoodAdapter.foodViewHolder>() {
    var foodlist:List<Food> = listOf()


    inner class foodViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        //lateinit var foodItem: Food

        fun bindFood(foodItem: Food) {
           // this.foodItem = foodItem
            Picasso.get()
                .load("https://wedding-service.khaingthinkyi.me/" + foodItem.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.foodImage)
            itemView.foodName.text = foodItem.name
            itemView.cardFood.setOnClickListener{
                fc.onFoodDetailClick(foodItem)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foodViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return foodViewHolder(view)
    }

    override fun getItemCount(): Int = foodlist.size

    override fun onBindViewHolder(holder: foodViewHolder, position: Int) {
        holder.bindFood(foodlist[position])
    }
    fun updateList(foodList: List<Food>){
        this.foodlist = foodList
        notifyDataSetChanged()
    }


}