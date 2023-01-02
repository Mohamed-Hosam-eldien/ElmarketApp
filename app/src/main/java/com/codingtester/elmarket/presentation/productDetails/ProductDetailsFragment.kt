package com.codingtester.elmarket.presentation.productDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.databinding.FragmentProductDetailsBinding
import com.codingtester.elmarket.presentation.shop.adapter.SliderAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class ProductDetailsFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var dots: DotsIndicator

    private lateinit var binding: FragmentProductDetailsBinding
    private val saveArgs = navArgs<ProductDetailsFragmentArgs>()

    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = saveArgs.value.productDetails
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initProductImagesSlider()
        binding.txtProductName.text = product.title
    }

    private fun initProductImagesSlider(){
        viewPager = binding.viewPagerAds
        dots = binding.dotsIndicator
        viewPager.adapter = ProductImagesAdapter(requireContext(), product.images)
        dots.attachTo(viewPager)
    }

}