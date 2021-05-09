package com.trendyol.dolap.feature.productdetail.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse
import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse
import com.trendyol.dolap.feature.productdetail.interactor.GetProduct
import com.trendyol.dolap.feature.productdetail.interactor.GetSocial
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner



@RunWith(MockitoJUnitRunner::class)
class ProductDetailFragmentViewModelTest {

    @get:Rule
    val executer = InstantTaskExecutorRule()

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    @Mock
    lateinit var getProduct: GetProduct

    @Mock
    lateinit var getProductObserver: GetProductObserver

    @Mock
    lateinit var productParam: GetProduct.Params

    @Mock
    lateinit var getSocial: GetSocial

    @Mock
    lateinit var getSocialObserver: GetSocialObserver

    @Mock
    lateinit var socialParam: GetSocial.Params

    @InjectMocks
    lateinit var viewModel: ProductDetailFragmentViewModel

    @Test
    fun testGetProduct() {
        // when
        viewModel.getProduct(getProductObserver, productParam)
        // then
        Mockito.verify(getProduct).execute(getProductObserver, productParam)
    }

    @Test
    fun testGetSocial() {
        // when
        viewModel.getSocial(getSocialObserver, socialParam)
        // then
        Mockito.verify(getSocial).execute(getSocialObserver, socialParam)
    }

    @Test
    fun handleProduct() {
        // given
        val res = ProductResponse()
        // when
        viewModel.handleProduct(res)
        // then
        Assert.assertNotNull(viewModel.productHandledMutableLiveData.value)
        Assert.assertNotNull(viewModel.productInfoObservable.get())
    }

    @Test
    fun handleSocial() {
        // given
        val res = SocialResponse()
        // when
        viewModel.handleSocial(res)
        // then
        Assert.assertNotNull(viewModel.socialDataMutableLiveData.value)
    }
}
