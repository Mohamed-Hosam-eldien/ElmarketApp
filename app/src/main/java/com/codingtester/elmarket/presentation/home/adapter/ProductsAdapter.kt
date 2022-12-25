package com.codingtester.elmarket.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingtester.elmarket.R
import com.codingtester.elmarket.data.pojo.Product

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private val products = arrayListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = products[position]

        holder.productTitle.text = currentProduct.title
        holder.productBrand.text = currentProduct.brand
        holder.productRate.text = currentProduct.rating.toString()
        holder.productPrice.text = currentProduct.price.toString().plus(" $")

        Glide.with(holder.itemView.context)
            .load(currentProduct.thumbnail)
            .into(holder.productImage)

        holder.imgFav.setOnClickListener{

        }

        holder.productCard.setOnClickListener{

        }

    }

    override fun getItemCount() = products.size

    fun setProductList(newProducts: List<Product>) {
        val productDiff = ProductDiffUtil(products, newProducts)
        val diffResult = DiffUtil.calculateDiff(productDiff)
        products.clear()
        products.addAll(newProducts)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage:ImageView = itemView.findViewById(R.id.imgProduct)
        val productTitle:TextView = itemView.findViewById(R.id.txtProductTitle)
        val productBrand:TextView = itemView.findViewById(R.id.txtProductBrand)
        val productPrice:TextView = itemView.findViewById(R.id.txtProductPrice)
        val productRate:TextView = itemView.findViewById(R.id.txtProductRate)
        val imgFav:ImageView = itemView.findViewById(R.id.imgFav)
        val productCard:CardView = itemView.findViewById(R.id.productCard)
    }

}