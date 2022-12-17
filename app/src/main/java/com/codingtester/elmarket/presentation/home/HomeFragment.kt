package com.codingtester.elmarket.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.codingtester.elmarket.databinding.FragmentHomeBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var dots: DotsIndicator
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdsSlider()
        getAllProduct()
    }

    private fun initAdsSlider(){
        viewPager = binding.viewPagerAds
        dots = binding.dotsIndicator
        sliderAdapter = SliderAdapter(requireContext())

        viewPager.adapter = sliderAdapter
        dots.attachTo(viewPager)
    }

    private fun getAllProduct() {
        homeViewModel.getAllProducts()
        lifecycleScope.launchWhenStarted{
            homeViewModel.productList.collectLatest {
                Log.e("TAG", "products 0 list: --> $it")
            }
        }
    }

}