package com.wws.weddingservice.ui.food

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val created_at: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: String,
    val updated_at: String
) : Parcelable