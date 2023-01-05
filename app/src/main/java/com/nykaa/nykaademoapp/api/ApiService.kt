package com.nykaa.nykaademoapp.api

import com.nykaa.nykaademoapp.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/products")
    suspend fun getProductList(@Query("page") page: Int): Response<ApiResponse>

}