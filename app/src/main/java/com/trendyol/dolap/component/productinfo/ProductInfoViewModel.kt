package com.trendyol.dolap.component.productinfo

import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import androidx.databinding.ObservableInt
import com.trendyol.base.component.BaseComponentViewModel
import com.trendyol.dolap.component.countdown.CircularCountDownViewData
import java.util.*

class ProductInfoViewModel: BaseComponentViewModel<ProductInfoViewData>() {

    val brand = ObservableField<String>("-")
    val name = ObservableField<String>("-")
    val likeCount = ObservableField<String>("0")
    val rating = ObservableFloat(5.0f)
    val ratingStr = ObservableField<String>("5.0")
    val commentCount = ObservableField<String>("0")
    val price = ObservableField<String>("0 TL")
    val countDown = ObservableField(CircularCountDownViewData(20, 1))
    val posterPath = ObservableField<String>("https://dummyimage.com/300x450/4a4a4a/26d6a1")

    override fun handleInput(viewData: ProductInfoViewData) {
        brand.set(viewData.brand)
        name.set(viewData.name)
        likeCount.set(viewData.likeCount.toString())
        rating.set(viewData.rating)
        ratingStr.set(viewData.rating.toString())
        commentCount.set(viewData.commentCount.toString())
        price.set(viewData.price)
        countDown.set(CircularCountDownViewData(viewData.countDown, 1))
    }
}