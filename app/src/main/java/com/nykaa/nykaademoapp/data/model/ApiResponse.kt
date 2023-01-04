package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(

    @SerializedName("status") var status: String? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("response") var response: Response?,
)