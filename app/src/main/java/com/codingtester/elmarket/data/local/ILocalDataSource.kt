package com.codingtester.elmarket.data.local

import com.codingtester.elmarket.data.pojo.Product

interface ILocalDataSource {

    suspend fun insertProductsToCaching(products:List<Product>)

    suspend fun getAllProductsFromCaching():List<Product>

    suspend fun clearProductsFromCaching()
}