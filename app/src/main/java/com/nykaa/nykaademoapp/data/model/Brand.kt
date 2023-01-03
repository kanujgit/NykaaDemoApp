package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class Brand(

    @SerializedName("count") var count: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,

    )