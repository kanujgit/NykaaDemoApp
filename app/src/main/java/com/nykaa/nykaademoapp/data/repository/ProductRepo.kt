package com.nykaa.nykaademoapp.data.repository

import com.nykaa.nykaademoapp.api.ApiService
import com.nykaa.nykaademoapp.data.model.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(private val apiService: ApiService) {
    fun getProductList(): Flow<Response<ApiResponse>> = flow {
        emit(apiService.getCountries())
    }.flowOn(Dispatchers.IO)
}