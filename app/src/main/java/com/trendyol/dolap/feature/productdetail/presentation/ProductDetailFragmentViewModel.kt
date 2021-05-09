package com.trendyol.dolap.feature.productdetail.presentation

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.trendyol.base.ui.BaseViewModel
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

    fun parseArguments(arguments: Bundle?) {
        arguments?.apply {
        }
    }
}