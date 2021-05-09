package com.trendyol.dolap.feature.productdetail.data

import javax.inject.Inject

class ProductDetailDataRepository @Inject constructor(
    private val productDetailRemoteDataSource: ProductDetailRemoteDataSource
): ProductDetailRepository {

    override fun getProduct(productId: Int?) = productDetailRemoteDataSource.getProduct(productId)

    override fun getSocial(productId: Int?) = productDetailRemoteDataSource.getSocial(productId)
}