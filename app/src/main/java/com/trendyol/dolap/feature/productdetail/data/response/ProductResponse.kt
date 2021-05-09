package com.trendyol.dolap.feature.productdetail.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ProductResponse(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("desc")
    val desc: String? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("price")
    val price: Price? = null
) {
}

@Parcelize
data class Price(
    @SerializedName("value")
    val value: Int? = null,

    @SerializedName("currency")
    val currency: String? = null
): Parcelable