package com.trendyol.dolap.feature.productdetail.interactor

import com.trendyol.dolap.feature.productdetail.data.ProductDetailRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetProductTest {

    @Mock
    lateinit var productDetailRepository: ProductDetailRepository

    @InjectMocks
    lateinit var getProduct: GetProduct

    @Test
    fun testBuildUseCaseObservable() {
        // when
        getProduct.buildUseCaseObservable(GetProduct.Params(1))

        // then
        Mockito.verify(productDetailRepository).getProduct(1)
    }
}