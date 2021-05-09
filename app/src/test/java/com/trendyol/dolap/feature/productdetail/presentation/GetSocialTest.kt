package com.trendyol.dolap.feature.productdetail.presentation

import com.trendyol.dolap.feature.productdetail.data.ProductDetailRepository
import com.trendyol.dolap.feature.productdetail.interactor.GetSocial
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSocialTest {

    @Mock
    lateinit var productDetailRepository: ProductDetailRepository

    @InjectMocks
    lateinit var getSocial: GetSocial

    @Test
    fun testBuildUseCaseObservable() {
        // when
        getSocial.buildUseCaseObservable(GetSocial.Params(1))

        // then
        Mockito.verify(productDetailRepository).getSocial(1)
    }
}