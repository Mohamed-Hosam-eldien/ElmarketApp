package com.codingtester.elmarket.data.repository

import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response

interface IProductRepo {

    suspend fun getAllRemoteProducts(): List<Product>?

    suspend fun getAllCashingProducts(): List<Product>

    suspend fun insertProductsToCaching(product:Product)

    suspend fun clearAllProductsFromCaching()

    suspend fun isProductFav(id : Int) : Boolean

    suspend fun updateProductFavorite(isFav:Boolean, id:Int)
}