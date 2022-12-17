package com.codingtester.elmarket.data.network

import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsService {

    @GET("products")
    suspend fun getAllProducts(): Response<ProductsResponse>


}