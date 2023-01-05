package com.nykaa.nykaademoapp.ui.productlist.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nykaa.nykaademoapp.api.ApiService
import com.nykaa.nykaademoapp.data.model.Products
import timber.log.Timber
import javax.inject.Inject

class ProductPagingSource @Inject constructor(private val apiService: ApiService) :
    PagingSource<Int, Products>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Products> {
        return try {
            val position = params.key ?: 1
            val response = apiService.getProductList(position)
            LoadResult.Page(data = response.body()?.response?.products!!,
                prevKey = if (position == 1) null else position - 1,
                nextKey = position + 1)
        } catch (e: Exception) {
            Timber.d("error in data ${e.message}")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Products>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}