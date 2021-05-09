package com.trendyol.dolap.feature.productdetail.interactor

import com.trendyol.base.usecase.network.BaseNetworkUseCase
import com.trendyol.dolap.feature.productdetail.data.ProductDetailRepository
import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetSocial@Inject constructor(
    private val productDetailRepository: ProductDetailRepository
): BaseNetworkUseCase<SocialResponse, GetSocial.Params>() {

    override fun buildUseCaseObservable(params: Params) =
        productDetailRepository.getSocial(params.productId)

    data class Params(val productId: Int?)
}