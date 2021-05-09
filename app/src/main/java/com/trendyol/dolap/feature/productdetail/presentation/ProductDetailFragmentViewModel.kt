package com.trendyol.dolap.feature.productdetail.presentation

import android.os.Bundle
import androidx.databinding.ObservableField
import androidx.lifecycle.SavedStateHandle
import com.trendyol.base.ui.BaseViewModel
import com.trendyol.dolap.component.productinfo.ProductInfoViewData
import com.trendyol.dolap.feature.productdetail.interactor.GetProduct
import com.trendyol.dolap.feature.productdetail.interactor.GetSocial
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailFragmentViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProduct: GetProduct,
    private val getSocial: GetSocial
): BaseViewModel() {

    val productInfoObservable = ObservableField<ProductInfoViewData>(
        ProductInfoViewData("fqf","qfq",94, 4.7f, 242, "2525TL", 20, "https://dummyimage.com/300x450/4a4a4a/26d6a1")
    )

    fun parseArguments(arguments: Bundle?) {
        arguments?.apply {
        }
    }
}