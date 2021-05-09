package com.trendyol.dolap.feature.productdetail.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ProductResponse(
    @SerializedName("product")
    val product: Product? = null,

    @SerializedName("social")
    val social: Social? = null,
) {
}

@Parcelize
data class Product(
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
): Parcelable

@Parcelize
data class Price(
    @SerializedName("value")
    val value: Int? = null,

    @SerializedName("currency")
    val currency: String? = null
): Parcelable

@Parcelize
data class Social(
    @SerializedName("likeCount")
    val likeCount: Int? = null,

    @SerializedName("commentCounts")
    val commentCounts: CommentCounts? = null
): Parcelable

