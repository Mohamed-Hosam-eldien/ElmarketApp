package com.codingtester.elmarket.data.repository

import com.codingtester.elmarket.data.network.RemoteDataSource
import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : IProductRepo {

    override suspend fun getAllProducts(): Response<ProductsResponse> {
        return remoteDataSource.getProductsList()
    }

}