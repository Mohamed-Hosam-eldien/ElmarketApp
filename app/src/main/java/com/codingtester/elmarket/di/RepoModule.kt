package com.codingtester.elmarket.di

import com.codingtester.elmarket.data.repos.IProductRepo
import com.codingtester.elmarket.data.repos.ProductRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun injectProductRepo(
        productRepo: ProductRepo
    ): IProductRepo

}