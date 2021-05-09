package com.trendyol.dolap.feature.productdetail.data

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductDetailRemoteDataSourceTest {

    @Mock
    lateinit var productDetailApiService: ProductDetailApiService

    @InjectMocks
    lateinit var remoteDataSource: ProductDetailRemoteDataSource

    @Test
    fun testGetProduct() {
        // given
        val productId = 1
        // when
        remoteDataSource.getProduct(productId)
        //then
        Mockito.verify(productDetailApiService).getProduct(productId)
    }

    @Test
    fun testGetSocial() {
        // given
        val productId = 1
        // when
        remoteDataSource.getSocial(productId)
        //then
        Mockito.verify(productDetailApiService).getSocial(productId)
    }
}