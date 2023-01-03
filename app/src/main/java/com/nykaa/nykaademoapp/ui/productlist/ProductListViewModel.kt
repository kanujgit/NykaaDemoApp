package com.nykaa.nykaademoapp.ui.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nykaa.nykaademoapp.api.ApiState
import com.nykaa.nykaademoapp.data.repository.ProductRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class ProductListViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {

    private val _productData = MutableStateFlow<ApiState>(ApiState.Empty)
    val onProductData = _productData

    init {
        productListing()
    }

    private fun productListing() {
        viewModelScope.launch {
            _productData.value = ApiState.Loading
            repo.getProductList().catch { e ->
                _productData.value = ApiState.Failure(e)
                Timber.d("catch $e")
            }.collect { data ->
                if (data.isSuccessful) {
                    if (data.body()?.status == "success") _productData.value =
                        ApiState.Success(data.body()?.response!!)
                    else _productData.value = ApiState.Failure(data.body()?.message!!)
                } else {
                    _productData.value = ApiState.Failure(data.raw().message)
                }
            }
        }
    }
}