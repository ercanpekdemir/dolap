package com.trendyol.dolap.feature.productdetail.presentation

import androidx.lifecycle.SavedStateHandle
import com.trendyol.base.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailActivityViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): BaseViewModel() {
}