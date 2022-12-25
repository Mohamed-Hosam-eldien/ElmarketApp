package com.codingtester.elmarket.di

import com.codingtester.elmarket.data.local.ILocalDataSource
import com.codingtester.elmarket.data.local.LocalDataSource
import com.codingtester.elmarket.data.network.IRemoteDataSource
import com.codingtester.elmarket.data.network.RemoteDataSource
import com.codingtester.elmarket.data.repository.IProductRepo
import com.codingtester.elmarket.data.repository.ProductRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun injectProductRepo(
        productRepo: ProductRepo
    ): IProductRepo

    @Binds
    fun provideRemoteDataSource(
        remoteDS: RemoteDataSource
    ): IRemoteDataSource

    @Binds
    fun provideLocalDataSource(
        localDS: LocalDataSource
    ): ILocalDataSource
}