package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class Filters(

    @SerializedName("category") var category: ArrayList<Category> = arrayListOf(),
    @SerializedName("star_rating") var starRating: ArrayList<StarRating> = arrayListOf(),
    @SerializedName("brand") var brand: ArrayList<Brand> = arrayListOf(),
    @SerializedName("discount") var discount: ArrayList<Discount> = arrayListOf(),
    @SerializedName("price") var price: Price? = Price(),

    )