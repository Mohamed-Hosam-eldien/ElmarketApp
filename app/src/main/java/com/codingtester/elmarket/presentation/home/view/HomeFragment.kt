package com.codingtester.elmarket.presentation.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.codingtester.elmarket.databinding.FragmentHomeBinding
import com.codingtester.elmarket.presentation.home.viewmodel.HomeViewModel
import com.codingtester.elmarket.presentation.home.adapter.ProductsAdapter
import com.codingtester.elmarket.presentation.home.adapter.SliderAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var dots: DotsIndicator
    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()
    private val productAdapter by lazy { ProductsAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdsSlider()
        initRecycler()
        getAllProduct()
    }

    private fun initRecycler() = binding.recyclerProducts.apply {
        adapter = productAdapter
        layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
    }

    private fun initAdsSlider(){
        viewPager = binding.viewPagerAds
        dots = binding.dotsIndicator
        viewPager.adapter = SliderAdapter(requireContext())
        dots.attachTo(viewPager)
    }

    private fun getAllProduct() = lifecycleScope.launchWhenStarted {
        homeViewModel.getAllProducts()
        homeViewModel.productList.collectLatest { products ->
            productAdapter.setProductList(products)
        }
    }

}