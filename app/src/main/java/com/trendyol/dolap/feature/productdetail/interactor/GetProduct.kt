package com.trendyol.dolap.feature.productdetail.interactor

import com.trendyol.base.usecase.network.BaseNetworkUseCase
import com.trendyol.dolap.feature.productdetail.data.ProductDetailRepository
import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetProduct @Inject constructor(
    private val productDetailRepository: ProductDetailRepository
): BaseNetworkUseCase<ProductResponse, GetProduct.Params>() {

    override fun buildUseCaseObservable(params: Params) =
        productDetailRepository.getProduct(params.productId)

    data class Params(val productId: Int?)
}