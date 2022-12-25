package com.codingtester.elmarket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.codingtester.elmarket.data.pojo.Product

@Database(
    entities = [Product::class],
    version = 1
)
@TypeConverters(
    ProductTypeConverter::class
)
abstract class ProductsDatabase:RoomDatabase() {

    abstract fun productDao(): ProductDao
}