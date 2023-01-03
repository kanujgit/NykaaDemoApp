package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class PrimaryCategories(

  @SerializedName("l2") var l2: L2? = L2(),
  @SerializedName("l3") var l3: L3? = L3(),
  @SerializedName("l1") var l1: L1? = L1(),

  )