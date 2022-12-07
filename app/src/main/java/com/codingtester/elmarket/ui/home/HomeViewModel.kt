package com.codingtester.elmarket.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.data.repos.IProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val iProductRepo: IProductRepo)
    : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val productList:LiveData<List<Product>> = _products

    fun getAllProducts() {
        viewModelScope.launch {
            _products.postValue(iProductRepo
                    .getAllProducts()
                    .body()?.products)
        }
    }

}