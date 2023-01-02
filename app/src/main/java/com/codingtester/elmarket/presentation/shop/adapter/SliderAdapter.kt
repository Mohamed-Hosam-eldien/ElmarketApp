package com.codingtester.elmarket.presentation.shop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.codingtester.elmarket.R

class SliderAdapter(private var context: Context, private var images: List<Any>): PagerAdapter() {

    private lateinit var layoutInflater:LayoutInflater

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View = layoutInflater.inflate(R.layout.slide_item,null)
        val imageView:ImageView = view.findViewById(R.id.slideImage)
        imageView.setImageResource(images[position] as Int)
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