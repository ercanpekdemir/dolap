package com.trendyol.dolap.feature.productdetail.data

import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse
import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse
import io.reactivex.Single

interface ProductDetailRepository {
    fun getProduct(productId: Int? = 1) : Single<ProductResponse>

    fun getSocial(productId: Int? = 1) : Single<SocialResponse>
}