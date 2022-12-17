package com.codingtester.elmarket.data.repository

import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response

interface IProductRepo {

    suspend fun getAllProducts(): Response<ProductsResponse>

}