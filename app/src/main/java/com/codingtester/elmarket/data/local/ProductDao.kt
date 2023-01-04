package com.codingtester.elmarket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingtester.elmarket.data.pojo.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(product:Product)

    @Query("delete from product")
    suspend fun clearProductsList()

    @Query("select * from Product")
    suspend fun getAllProducts():List<Product>

    @Query("SELECT EXISTS(SELECT * FROM product WHERE id = :id)")
    suspend fun isProductFav(id : Int) : Boolean

    @Query("update product set isFavorite = :isFav where id = :id")
    suspend fun updateProductFavorite(isFav:Boolean, id:Int)
}