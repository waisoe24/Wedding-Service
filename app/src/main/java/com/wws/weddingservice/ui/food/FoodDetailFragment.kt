package com.wws.weddingservice.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.wws.weddingservice.R
import com.wws.weddingservice.adapter.FoodAdapter
import kotlinx.android.synthetic.main.fragment_food_detail.*


class FoodDetailFragment : Fragment() {

    companion object {
        fun newInstance() = FoodDetailFragment()
    }

    private lateinit var foodDetailViewModel: FoodViewModel
    private lateinit var foodDetailAdapter: FoodAdapter
    private lateinit var food:List<Food>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var messageArgs = arguments?.let { FoodDetailFragmentArgs.fromBundle(it) }

        var image = messageArgs?.foodDetail?.image
        //Toast.makeText(context, image.toString(),Toast.LENGTH_LONG).show()
        var name = messageArgs?.foodDetail?.name
        var price = messageArgs?.foodDetail?.price


        Picasso.get()
            .load("https://wedding-service.khaingthinkyi.me/"+image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(fDetailImage)
        foodDetailName.text=name
        foodDetailPrice.text= price


    }




}
