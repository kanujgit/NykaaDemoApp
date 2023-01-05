package com.nykaa.nykaademoapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nykaa.nykaademoapp.api.ApiConstant
import com.nykaa.nykaademoapp.data.model.Products
import com.nykaa.nykaademoapp.ui.productlist.paging.ProductPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepo @Inject constructor(private val pagingSource: ProductPagingSource) {

    fun getProductList(): Flow<PagingData<Products>> {
        return Pager(config = PagingConfig(pageSize = ApiConstant.PAGE_SIZE,
            enablePlaceholders = false,
            initialLoadSize = 2), pagingSourceFactory = {
            pagingSource
        }, initialKey = 1).flow
    }
}
