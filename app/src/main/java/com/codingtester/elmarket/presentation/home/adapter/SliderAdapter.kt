package com.codingtester.elmarket.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.codingtester.elmarket.R

class SliderAdapter(private var context: Context): PagerAdapter() {

    private lateinit var layoutInflater:LayoutInflater
    private val images = listOf( R.drawable.ads1, R.drawable.ads2, R.drawable.ads3,
        R.drawable.ads4, R.drawable.ads5, R.drawable.ads6)

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
        imageView.setImageResource(images[position])
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