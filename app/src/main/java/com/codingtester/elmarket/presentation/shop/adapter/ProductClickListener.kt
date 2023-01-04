package com.codingtester.elmarket.presentation.shop.adapter

import com.codingtester.elmarket.data.pojo.Product

interface ProductClickListener {

    fun clickOnProduct(product:Product)

    fun clickOnProductFav(product: Product)
}