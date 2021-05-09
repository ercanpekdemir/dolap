package com.trendyol.dolap.feature.productdetail.presentation

import com.trendyol.dolap.feature.productdetail.data.response.SocialResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSocialObserverTest {

    @Mock
    lateinit var viewModel: ProductDetailFragmentViewModel

    @InjectMocks
    lateinit var observer: GetSocialObserver

    @Test
    fun onResultSuccess() {
        // given
        val response = Mockito.mock(SocialResponse::class.java)
        // when
        observer.onResultSuccess(response)
        // then
        Mockito.verify(viewModel).handleSocial(response)
    }

    @Test
    fun onResultFail() {
    }
}