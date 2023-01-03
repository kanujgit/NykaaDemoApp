package com.nykaa.nykaademoapp.api

import com.nykaa.nykaademoapp.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/products?page=1")
    suspend fun getCountries(): Response<ApiResponse>

}