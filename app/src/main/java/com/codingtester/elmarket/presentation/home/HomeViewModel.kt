package com.codingtester.elmarket.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingtester.elmarket.data.pojo.Product
import com.codingtester.elmarket.data.repository.IProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val iProductRepo: IProductRepo)
    : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val productList = _products.asStateFlow()

    fun getAllProducts() {
        viewModelScope.launch {
            _products.value = iProductRepo.getAllProducts().body()?.products ?: emptyList()
        }
    }

}