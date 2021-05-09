package com.trendyol.dolap.feature.productdetail.di

import com.trendyol.base.network.BaseRetrofit
import com.trendyol.dolap.feature.productdetail.data.ProductDetailApiService
import com.trendyol.dolap.feature.productdetail.data.ProductDetailDataRepository
import com.trendyol.dolap.feature.productdetail.data.ProductDetailRemoteDataSource
import com.trendyol.dolap.feature.productdetail.data.ProductDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ProductDetailModule {

    @ViewModelScoped
    @Provides
    fun provideProductDetailRemoteDataSource(baseRetrofit: BaseRetrofit): ProductDetailRemoteDataSource =
        ProductDetailRemoteDataSource(baseRetrofit.create(ProductDetailApiService::class.java, "https://demo4200254.mockable.io/"))

    @ViewModelScoped
    @Provides
    fun provideProductDetailRepository(remoteDataSource: ProductDetailRemoteDataSource): ProductDetailRepository =
        ProductDetailDataRepository(remoteDataSource)
}