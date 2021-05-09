package com.trendyol.dolap.component.productinfo

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import com.trendyol.base.component.BaseComponent
import com.trendyol.dolap.R
import com.trendyol.dolap.databinding.ComponentProductInfoBinding

@BindingAdapter("viewData")
fun ProductInfoView.setData(viewData: ProductInfoViewData) {
    viewModel.handleInput(viewData)
}

class ProductInfoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : BaseComponent<ComponentProductInfoBinding, ProductInfoViewModel>(context, attrs, defStyleAttr) {

    override fun provideViewModel() = ProductInfoViewModel()

    override fun bindViewModel(viewDataBinding: ComponentProductInfoBinding) {
        viewDataBinding.viewModel = viewModel
    }

    override fun provideLayoutId() = R.layout.component_product_info
}