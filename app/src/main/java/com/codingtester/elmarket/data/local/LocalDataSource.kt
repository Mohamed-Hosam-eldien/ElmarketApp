package com.codingtester.elmarket.data.local

import com.codingtester.elmarket.data.pojo.Product
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val productsDao: ProductDao
): ILocalDataSource {

    override suspend  fun insertProductsToCaching(product:Product) {
        productsDao.insertProducts(product)
    }

    override suspend  fun getAllProductsFromCaching(): List<Product> {
        return productsDao.getAllProducts()
    }

    override suspend fun clearProductsFromCaching() {
        productsDao.clearProductsList()
    }

    override suspend fun isProductFav(id: Int): Boolean {
        return productsDao.isProductFav(id)
    }

    override suspend fun updateProductFavorite(isFav: Boolean, id: Int) {
        productsDao.updateProductFavorite(isFav, id)
    }
}