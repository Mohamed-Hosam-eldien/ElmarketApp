package com.codingtester.elmarket.data.network

import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val productsService: ProductsService
) : IRemoteDataSource {

    override suspend fun getProductsList(): Response<ProductsResponse> {
        return productsService.getAllProducts()
    }

}