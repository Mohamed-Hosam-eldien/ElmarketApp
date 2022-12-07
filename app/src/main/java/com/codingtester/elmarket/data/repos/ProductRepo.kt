package com.codingtester.elmarket.data.repos

import com.codingtester.elmarket.data.network.RemoteDataSource
import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response

class ProductRepo(private val remoteDataSource:RemoteDataSource)
    : IProductRepo {

    override suspend fun getAllProducts(): Response<ProductsResponse> {
        return remoteDataSource.getProductsList()
    }

}