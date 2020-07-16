package com.wws.weddingservice.ui.hall

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hall(
    val area: String,
    val created_at: String,
    val id: Int,
    val image: String,
    val name: String,
    val person_no: String,
    val price: String,
    val updated_at: String
) : Parcelable