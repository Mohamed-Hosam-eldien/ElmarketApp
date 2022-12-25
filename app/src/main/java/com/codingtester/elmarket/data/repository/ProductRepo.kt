package com.codingtester.elmarket.data.repository

import com.codingtester.elmarket.data.local.LocalDataSource
import com.codingtester.elmarket.data.network.RemoteDataSource
import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.data.pojo.ProductsResponse
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IProductRepo {

    override suspend fun getAllRemoteProducts(): Response<ProductsResponse> {
        return remoteDataSource.getProductsList()
    }

    override suspend fun getAllCashingProducts(): List<Product> {
        return localDataSource.getAllProductsFromCaching()
    }

    override suspend fun insertProductsToCaching(products: List<Product>) {
        localDataSource.insertProductsToCaching(products)
    }

    override suspend fun clearAllProductsFromCaching() {
        localDataSource.clearProductsFromCaching()
    }


}