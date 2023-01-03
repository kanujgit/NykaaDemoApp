package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class FilterKeys(

    @SerializedName("filters") var filters: ArrayList<Filters> = arrayListOf(),
    @SerializedName("other_filters") var otherFilters: ArrayList<OtherFilters> = arrayListOf(),

    )