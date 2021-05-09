package com.trendyol.dolap.feature.productdetail.presentation

import com.trendyol.base.rx.BaseDisposableSingleObserver
import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse

class GetSocialObserver(private val viewModel: ProductDetailFragmentViewModel):
    BaseDisposableSingleObserver<SocialResponse>(viewModel) {

    override fun onResultSuccess(result: SocialResponse) {
        viewModel.handleSocial(result)
    }

    override fun onResultFail(e: Throwable) {
        // todo add error handler
    }


}