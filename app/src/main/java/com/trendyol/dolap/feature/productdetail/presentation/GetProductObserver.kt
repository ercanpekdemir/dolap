package com.trendyol.dolap.feature.productdetail.presentation

import com.trendyol.base.rx.BaseDisposableSingleObserver
import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse

class GetProductObserver(private val viewModel: ProductDetailFragmentViewModel):
    BaseDisposableSingleObserver<ProductResponse>(viewModel) {

    override fun onResultSuccess(result: ProductResponse) {
        viewModel.handleProduct(result)
    }

    override fun onResultFail(e: Throwable) {
        // todo add error handler
    }
}