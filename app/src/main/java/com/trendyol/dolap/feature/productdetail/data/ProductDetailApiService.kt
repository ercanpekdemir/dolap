package com.trendyol.dolap.feature.productdetail.data

import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse
import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductDetailApiService {
    @GET("product")
    fun getProduct(@Query("product_id") productId: Int? = 1) : Single<ProductResponse>

    @GET("social")
    fun getSocial(@Query("product_id") productId: Int? = 1) : Single<SocialResponse>
}