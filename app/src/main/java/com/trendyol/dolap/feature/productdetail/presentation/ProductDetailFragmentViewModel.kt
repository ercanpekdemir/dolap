package com.trendyol.dolap.feature.productdetail.presentation

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.trendyol.base.ui.BaseViewModel
import com.trendyol.dolap.component.productinfo.ProductInfoViewData
import com.trendyol.dolap.feature.productdetail.data.response.CommentCounts
import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse
import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse
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

    val productInfoObservable = ObservableField<ProductInfoViewData>()

    val productHandledMutableLiveData = MutableLiveData<Unit>()
    val socialDataMutableLiveData = MutableLiveData<SocialResponse?>()

    fun getProduct(observer: GetProductObserver, params: GetProduct.Params) {
        getProduct.execute(observer, params)
    }

    fun getSocial(observer: GetSocialObserver, params: GetSocial.Params) {
        getSocial.execute(observer, params)
    }

    //// fake social data /////
    private var likeCount: Int? = 0
    private var averageRating: Float? = 0.0f
    private var anonymousCommentsCount: Int? = 0
    private var memberCommentsCount: Int? = 0

    private fun initFakeSocialData(response: ProductResponse) {
        likeCount = response.social?.likeCount
        averageRating = response.social?.commentCounts?.averageRating
        anonymousCommentsCount = response.social?.commentCounts?.anonymousCommentsCount
        memberCommentsCount = response.social?.commentCounts?.memberCommentsCount
    }

    private fun generateFakeSocialData(): SocialResponse {
        likeCount = likeCount?.plus(1)
        averageRating = averageRating?.plus(0.1f)
        anonymousCommentsCount = anonymousCommentsCount?.plus(1)
        memberCommentsCount = memberCommentsCount?.plus(1)
        return SocialResponse(likeCount,
            CommentCounts(averageRating, anonymousCommentsCount, memberCommentsCount)
        )
    }
    ///// end fake social data /////

    fun handleSocial(response: SocialResponse) {
        socialDataMutableLiveData.value = generateFakeSocialData()
    }

    fun handleProduct(response: ProductResponse) {
        productInfoObservable.set(
            ProductInfoViewData(
                response.product?.name ?: "",
                response.product?.desc ?: "",
                response.social?.likeCount ?: 0,
                response.social?.commentCounts?.averageRating ?: 5.0f,
                (response.social?.commentCounts?.anonymousCommentsCount?:0) + (response.social?.commentCounts?.memberCommentsCount ?: 0),
                "${response.product?.price?.value ?: ""} ${response.product?.price?.currency ?: ""}",
                20,
                response.product?.image ?: ""
            )
        )
        productHandledMutableLiveData.value = Unit

        initFakeSocialData(response)
    }
}