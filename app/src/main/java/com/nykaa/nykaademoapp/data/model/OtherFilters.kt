package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class OtherFilters(

    @SerializedName("top_old_brand") var topOldBrand: ArrayList<TopOldBrand> = arrayListOf(),
    @SerializedName("top_brand") var topBrand: ArrayList<TopBrand> = arrayListOf(),

    )