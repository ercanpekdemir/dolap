package com.trendyol.dolap.component.countdown

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import com.trendyol.base.component.BaseComponent
import com.trendyol.dolap.R
import com.trendyol.dolap.databinding.ComponentCircularCountdownBinding

@BindingAdapter("viewData")
fun CircularCountDownView.setData(viewData: CircularCountDownViewData?) {
    viewData?.let {
        viewModel.handleInput(it)
    }
}

class CircularCountDownView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : BaseComponent<ComponentCircularCountdownBinding, CircularCountDownViewModel>(context, attrs, defStyleAttr) {

    override fun provideViewModel() = CircularCountDownViewModel()

    override fun bindViewModel(viewDataBinding: ComponentCircularCountdownBinding) {
        viewDataBinding.viewModel = viewModel
    }

    override fun provideLayoutId() = R.layout.component_circular_countdown
}