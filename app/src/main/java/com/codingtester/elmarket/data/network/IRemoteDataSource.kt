package com.codingtester.elmarket.data.network

import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response

interface IRemoteDataSource {

    suspend fun getProductsList():Response<ProductsResponse>

}