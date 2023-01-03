package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class Price(

    @SerializedName("price_range") var priceRange: ArrayList<PriceRange> = arrayListOf(),
    @SerializedName("min_price") var minPrice: Int? = null,
    @SerializedName("max_price") var maxPrice: Int? = null,

    )