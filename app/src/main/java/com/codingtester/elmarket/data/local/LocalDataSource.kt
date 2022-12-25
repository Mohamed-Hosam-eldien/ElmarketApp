package com.codingtester.elmarket.data.local

import com.codingtester.elmarket.data.pojo.Product
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val productsDao: ProductDao
): ILocalDataSource {

    override suspend  fun insertProductsToCaching(products: List<Product>) {
        productsDao.insertProducts(products)
    }

    override suspend  fun getAllProductsFromCaching(): List<Product> {
        return productsDao.getAllProducts()
    }

    override suspend fun clearProductsFromCaching() {
        productsDao.clearProductsList()
    }
}