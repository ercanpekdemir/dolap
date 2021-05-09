package com.trendyol.dolap.feature.productdetail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.trendyol.base.ui.BaseFragment
import com.trendyol.dolap.R
import com.trendyol.dolap.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<ProductDetailFragmentViewModel, FragmentProductDetailBinding>() {

    companion object {
        fun newInstance(param1: String, param2: String) =
            ProductDetailFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private val viewModel: ProductDetailFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        viewModel.parseArguments(arguments)
        return view
    }

    override fun provideLayoutResId() = R.layout.fragment_product_detail

    override fun bindViewModel(db: FragmentProductDetailBinding): ProductDetailFragmentViewModel {
        return viewModel.apply {
            db.viewModel = this
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}