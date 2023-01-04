package com.codingtester.elmarket.data.pojo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Product(
    @PrimaryKey
    val id: Int,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    @SerializedName("stock")
    val ratingCount: Int,
    val thumbnail: String,
    val title: String,
    var isFavorite: Boolean = false
): Parcelable