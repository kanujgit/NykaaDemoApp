package com.nykaa.nykaademoapp.ui.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nykaa.nykaademoapp.data.model.Products
import com.nykaa.nykaademoapp.data.repository.ProductRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductListViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {

    fun productListing(): Flow<PagingData<Products>> {
        return repo.getProductList().cachedIn(viewModelScope)
    }
}