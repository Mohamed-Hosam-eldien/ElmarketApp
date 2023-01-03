package com.codingtester.elmarket.presentation.productDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.databinding.FragmentProductDetailsBinding
import com.denzcoskun.imageslider.models.SlideModel


class ProductDetailsFragment : Fragment() {

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
        binding.txtPrice.text = product.price.toString().plus(" $")
        binding.txtDetails.text = product.description
        binding.txtProductBrand.text = product.brand
        binding.txtProductRate.text = product.rating.toString()
        binding.txtRatedCount.text = product.ratingCount.toString()
    }

    private fun initProductImagesSlider(){
        val list = arrayListOf<SlideModel>()
        product.images.forEach{
            list.add(SlideModel(it))
        }
        binding.imageSlider.setImageList(list)
    }

}