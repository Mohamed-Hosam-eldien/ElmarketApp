package com.codingtester.elmarket.data.local

import com.codingtester.elmarket.data.pojo.Product

interface ILocalDataSource {

    suspend fun insertProductsToCaching(product:Product)

    suspend fun getAllProductsFromCaching():List<Product>

    suspend fun clearProductsFromCaching()

    suspend fun isProductFav(id : Int) : Boolean

    suspend fun updateProductFavorite(isFav:Boolean, id:Int)
}