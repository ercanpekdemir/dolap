package com.trendyol.dolap.component.productinfo

import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import androidx.databinding.ObservableInt
import com.trendyol.base.component.BaseComponentViewModel
import com.trendyol.dolap.component.countdown.CircularCountDownViewData
import java.util.*

class ProductInfoViewModel: BaseComponentViewModel<ProductInfoViewData>() {

    val brand = ObservableField<String>()
    val name = ObservableField<String>()
    val likeCount = ObservableField<String>()
    val rating = ObservableFloat()
    val ratingStr = ObservableField<String>()
    val commentCount = ObservableField<String>()
    val price = ObservableField<String>()
    val countDown = ObservableField<CircularCountDownViewData>()
    val posterPath = ObservableField<String>()

    override fun handleInput(viewData: ProductInfoViewData) {
        brand.set(viewData.brand)
        name.set(viewData.name)
        likeCount.set(viewData.likeCount.toString())
        rating.set(String.format("%.1f", viewData.rating).toFloat())
        ratingStr.set(viewData.rating.toString())
        commentCount.set("(${viewData.commentCount} yorum)")
        price.set(viewData.price)
        countDown.set(CircularCountDownViewData(viewData.countDown, 1))
        posterPath.set(viewData.posterPath)
    }
}