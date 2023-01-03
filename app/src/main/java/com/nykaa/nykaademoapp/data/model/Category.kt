package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class Category(

    @SerializedName("count") var count: String? = null,
    @SerializedName("rgt") var rgt: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("parent_id") var parentId: String? = null,
    @SerializedName("lft") var lft: String? = null,
    @SerializedName("depth") var depth: String? = null,
    @SerializedName("include_in_menu") var includeInMenu: String? = null,
    @SerializedName("position") var position: String? = null,
    @SerializedName("category_id") var categoryId: String? = null,

    )