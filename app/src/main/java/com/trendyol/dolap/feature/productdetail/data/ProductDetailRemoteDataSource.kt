package com.trendyol.dolap.feature.productdetail.data

import javax.inject.Inject

class ProductDetailRemoteDataSource @Inject constructor(
    private val productDetailApiService: ProductDetailApiService
) {
    fun getProduct(productId: Int? = 1) = productDetailApiService.getProduct(productId)

    fun getSocial(productId: Int? = 1) = productDetailApiService.getSocial(productId)
}