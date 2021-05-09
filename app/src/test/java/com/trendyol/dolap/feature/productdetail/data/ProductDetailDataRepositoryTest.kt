package com.trendyol.dolap.feature.productdetail.data

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import javax.inject.Inject

@RunWith(MockitoJUnitRunner::class)
class ProductDetailDataRepositoryTest {

    @Mock
    lateinit var remoteDataSource: ProductDetailRemoteDataSource

    @InjectMocks
    lateinit var repository: ProductDetailDataRepository

    @Test
    fun testGetProduct() {
        // given
        val productId = 1
        // when
        repository.getProduct(productId)
        //then
        Mockito.verify(remoteDataSource).getProduct(productId)
    }

    @Test
    fun testGetSocial() {
        // given
        val productId = 1
        // when
        repository.getSocial(productId)
        //then
        Mockito.verify(remoteDataSource).getSocial(productId)
    }
}