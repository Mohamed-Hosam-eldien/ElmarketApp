package com.codingtester.elmarket.data.local

import androidx.room.TypeConverter
import com.codingtester.elmarket.data.pojo.Product
import com.google.gson.Gson

class ProductTypeConverter {

    @TypeConverter
    fun arrayToGson(images: List<String>)
            : String = Gson().toJson(images).toString()

    @TypeConverter
    fun gsonToList(images: String)
            : List<String> = Gson().fromJson(images, Array<String>::class.java).toList()
}