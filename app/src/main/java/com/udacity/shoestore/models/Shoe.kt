package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


//, var description: String,
//                val images: List<String> = mutableListOf()

@Parcelize
data class Shoe(
    var name: String = "",
    var size: String = "",
    var company: String = "",
    var description: String = ""
) :
    Parcelable