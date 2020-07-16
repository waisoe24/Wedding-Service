package com.wws.weddingservice.ui.hall

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.wws.weddingservice.R
import kotlinx.android.synthetic.main.fragment_hall_detail.*

class HallDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hall_detail, container, false)
    }

     private val sharedPrefFile = "TEST_SHARED_PREFERENCE"


  /*  fun getPrefs(context: Context): SharedPreferences? {
        return context.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
    }

    fun insertData(
        context: Context?,
        key: String?,
        value: Int
    ) {
        val editor = getPrefs(context!!)!!.edit()
        editor.putString(key, value.toString())
        editor.commit()
    }

    fun getData(
        context: Context?,
        key: String?,
        value: Int
    ) {
        val editor = getPrefs(context!!)!!.edit()
        editor.getString(key, "")
        editor.commit()
    }
*/
  //val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sharedPreferences = this.activity!!.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()




        var messageArgs = arguments?.let { HallDetailFragmentArgs.fromBundle(it) }
        var image = messageArgs?.hallDetail?.image
        //Toast.makeText(context, image.toString(),Toast.LENGTH_LONG).show()
        var id = messageArgs?.hallDetail?.id
        var name = messageArgs?.hallDetail?.name
        var price = messageArgs?.hallDetail?.price
        var person = messageArgs?.hallDetail?.person_no
        var area = messageArgs?.hallDetail?.area


        Picasso.get()
            .load("https://wedding-service.khaingthinkyi.me/"+image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(hDetailImage)
        hallDetailID.text = "ID: "+ id
        hallDetailName.text="Hall Name: "+name
        hallDetailPrice.text= "Price: "+price
        hallDetailPerson.text = "Person No: "+person
        hallDetailArea.text = "Area: "+area

        hBookButton.setOnClickListener {

            val id = hallDetailID.text.toString()

            // insertData(this.context,"ID", id.toInt())
            editor.putString("bid",id)
            editor.apply()
            editor.commit()
            var t=sharedPreferences.getString("bid","")
           if(id.equals(t)){
               getView()?.let { it1 -> Snackbar.make(it1,"Booking Successfully",Snackbar.LENGTH_LONG).show() }
           }

        }

    }
}