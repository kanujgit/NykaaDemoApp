package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class PriceRange(

  @SerializedName("count") var count: String? = null,
  @SerializedName("max") var max: String? = null,
  @SerializedName("min") var min: String? = null,

  )