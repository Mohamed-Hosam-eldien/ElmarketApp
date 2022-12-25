package com.codingtester.elmarket.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codingtester.elmarket.data.local.ProductDao
import com.codingtester.elmarket.data.local.ProductsDatabase
import com.codingtester.elmarket.data.pojo.Product
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ProductsDatabase::class.java,
            "ElmarketDB"
        ).build()


    @Provides
    fun provideDao(db: ProductsDatabase): ProductDao = db.productDao()
}