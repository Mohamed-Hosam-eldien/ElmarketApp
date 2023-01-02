package com.codingtester.elmarket.presentation.productDetails

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.codingtester.elmarket.R

class ProductImagesAdapter(private var context: Context,private val images:List<String>): PagerAdapter() {

    private lateinit var layoutInflater:LayoutInflater


    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View = layoutInflater.inflate(R.layout.slide_product_item,null)

        val imageView:ImageView = view.findViewById(R.id.slideImageProduct)
        Glide.with(context).load(images[position]).into(imageView)

        val viewPager: ViewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager: ViewPager = container as ViewPager
        val view:View = `object` as View
        viewPager.removeView(view)
    }

}