package com.trendyol.dolap.component.productinfo

import com.trendyol.base.component.BaseComponentViewData

data class ProductInfoViewData(
    val brand: String,
    val name: String,
    val likeCount: Int,
    val rating: Float,
    val commentCount: Int,
    val price: String,
    val countDown: Int,
    val posterPath: String
): BaseComponentViewData {
}