package com.codingtester.elmarket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingtester.elmarket.data.pojo.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products:List<Product>)

    @Query("delete from product")
    suspend fun clearProductsList()

    @Query("select * from Product")
    suspend fun getAllProducts():List<Product>
}