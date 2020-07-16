package com.wws.weddingservice.ui.packages

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Service(
    val created_at: String,
    val id: Int,
    val name: String,
    //val pivot: Pivot,
    val updated_at: String
) : Parcelable