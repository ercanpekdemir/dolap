package com.trendyol.dolap.feature.productdetail.presentation

import com.trendyol.dolap.feature.productdetail.data.response.ProductResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetProductObserverTest {

    @Mock
    lateinit var viewModel: ProductDetailFragmentViewModel

    @InjectMocks
    lateinit var observer: GetProductObserver

    @Test
    fun onResultSuccess() {
        // given
        val response = Mockito.mock(ProductResponse::class.java)
        // when
        observer.onResultSuccess(response)
        // then
        Mockito.verify(viewModel).handleProduct(response)
    }

    @Test
    fun onResultFail() {
    }
}