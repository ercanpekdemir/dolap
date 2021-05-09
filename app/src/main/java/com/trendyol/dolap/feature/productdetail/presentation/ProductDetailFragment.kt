package com.trendyol.dolap.feature.productdetail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.trendyol.base.ui.BaseFragment
import com.trendyol.dolap.R
import com.trendyol.dolap.component.countdown.CircularCountDownHandler
import com.trendyol.dolap.databinding.FragmentProductDetailBinding
import com.trendyol.dolap.feature.productdetail.interactor.GetProduct
import com.trendyol.dolap.feature.productdetail.interactor.GetSocial
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<ProductDetailFragmentViewModel, FragmentProductDetailBinding>(),
    CircularCountDownHandler {

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
        observeViewModel()
        viewModel.getProduct(GetProductObserver(viewModel), GetProduct.Params(1))
        return view
    }

    private fun observeViewModel() {
        viewModel.apply {
            socialDataMutableLiveData.observeForever { res ->
                res?.let { socialResponse ->
                    binding.productInfoView.viewModel.apply {
                        rating.set(socialResponse.commentCounts?.averageRating?:5.0f)
                        ratingStr.set(String.format("%.1f", socialResponse.commentCounts?.averageRating))
                        likeCount.set(socialResponse.likeCount?.toString() ?: "")
                        commentCount.set("(${((socialResponse.commentCounts?.anonymousCommentsCount?:0) + (socialResponse.commentCounts?.memberCommentsCount ?: 0))} yorum)")
                    }
                }
            }
            productHandledMutableLiveData.observe(viewLifecycleOwner) {
                binding.productInfoView.dataBinding.countdown.viewModel.handler = this@ProductDetailFragment
            }
        }
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

    override fun onFinish() {
        viewModel.getSocial(GetSocialObserver(viewModel), GetSocial.Params(1))
        binding.productInfoView.dataBinding.countdown.viewModel.startTimer()
    }

}