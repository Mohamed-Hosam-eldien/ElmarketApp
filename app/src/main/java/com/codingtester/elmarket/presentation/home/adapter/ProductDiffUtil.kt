package com.codingtester.elmarket.presentation.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.codingtester.elmarket.data.pojo.Product

class ProductDiffUtil(
    private val oldList:List<Product>,
    private val newList:List<Product>
): DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList === newList

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList == newList
}