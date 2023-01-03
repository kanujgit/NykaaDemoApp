package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class Discount(

    @SerializedName("count") var count: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("value") var value: String? = null,

    )