package com.trendyol.dolap.feature.productdetail.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.trendyol.base.ui.BaseActivity
import com.trendyol.dolap.R
import com.trendyol.dolap.databinding.ActivityProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailActivity : BaseActivity<ProductDetailActivityViewModel, ActivityProductDetailBinding>() {

    private val viewModel: ProductDetailActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().run {
            add(binding.fragmentContainer.id, ProductDetailFragment.newInstance("",""))
            commit()
        }

    }

    override fun provideLayoutResId() = R.layout.activity_product_detail

    override fun bindViewModel(db: ActivityProductDetailBinding): ProductDetailActivityViewModel {
        return viewModel.apply {
            db.viewModel = this
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}