package com.wws.weddingservice.ui.packages

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Package(
    val name: String,
    val services: List<Service>
) : Parcelable