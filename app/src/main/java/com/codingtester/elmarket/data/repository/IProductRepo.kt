package com.codingtester.elmarket.data.repository

import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response

interface IProductRepo {

    suspend fun getAllRemoteProducts(): Response<ProductsResponse>

    suspend fun getAllCashingProducts(): List<Product>

    suspend fun insertProductsToCaching(products:List<Product>)

    suspend fun clearAllProductsFromCaching()
}