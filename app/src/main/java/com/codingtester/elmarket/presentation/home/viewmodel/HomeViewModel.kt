package com.codingtester.elmarket.presentation.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.data.repository.IProductRepo
import com.codingtester.elmarket.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val iProductRepo: IProductRepo,
    private val context: Application
) : AndroidViewModel(context) {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val productList = _products.asStateFlow()

    fun getAllProducts() {
        viewModelScope.launch {
            if(Constants.isNetworkAvailable(context)) {
                val productsFromAPI = iProductRepo.getAllRemoteProducts()
                    .body()?.products ?: emptyList()
                iProductRepo.clearAllProductsFromCaching()
                iProductRepo.insertProductsToCaching(productsFromAPI)
            }

            val productsFromCashing = iProductRepo.getAllCashingProducts()

            _products.value = productsFromCashing
        }
    }

}