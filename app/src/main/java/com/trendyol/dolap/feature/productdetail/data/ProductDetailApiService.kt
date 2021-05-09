package com.trendyol.dolap.feature.productdetail.data

import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse
import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDetailApiService {
    @GET("product?id={product_id}")
    fun getProduct(@Path("product_id") productId: Int? = 1) : Single<ProductResponse>

    @GET("social?id={product_id}")
    fun getSocial(@Path("product_id") productId: Int? = 1) : Single<SocialResponse>
}