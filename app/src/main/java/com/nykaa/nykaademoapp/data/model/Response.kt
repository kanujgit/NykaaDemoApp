package com.nykaa.nykaademoapp.data.model


import com.google.gson.annotations.SerializedName


data class Response(

    @SerializedName("product_count") var productCount: Int? = null,
    @SerializedName("total_found") var totalFound: Int? = null,
    @SerializedName("offset") var offset: Int? = null,
    @SerializedName("products") var products: List<Products>,
    @SerializedName("font_color") var fontColor: String? = null,
    @SerializedName("banner_video") var bannerVideo: String? = null,
    @SerializedName("filter_keys") var filterKeys: FilterKeys? = FilterKeys(),
    @SerializedName("banner_video_image") var bannerVideoImage: String? = null,
    @SerializedName("android_landing_url") var androidLandingUrl: String? = null,
    @SerializedName("isNewApi") var isNewApi: Boolean? = null,
    @SerializedName("art_title") var artTitle: String? = null,
    @SerializedName("filters") var filters: Filters? = Filters(),
    @SerializedName("query") var query: String? = null,
    @SerializedName("art_content") var artContent: String? = null,
    @SerializedName("other_filters") var otherFilters: OtherFilters? = OtherFilters(),
    @SerializedName("stop_further_call") var stopFurtherCall: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("size_chart_image") var sizeChartImage: String? = null,
    @SerializedName("app_sorting") var appSorting: String? = null,
    @SerializedName("namespace") var namespace: ArrayList<String> = arrayListOf(),
    @SerializedName("type") var type: String? = null,
    @SerializedName("ios_landing_url") var iosLandingUrl: String? = null,
    @SerializedName("sort") var sort: String? = null,
    @SerializedName("desktop_tip_tile") var desktopTipTile: String? = null,
    @SerializedName("tip_tile") var tipTile: String? = null,
    @SerializedName("banner_image") var bannerImage: String? = null,
    @SerializedName("art_link_text") var artLinkText: String? = null,
    @SerializedName("art_pos") var artPos: String? = null,
    @SerializedName("category_name") var categoryName: String? = null,
    @SerializedName("auth_certificate") var authCertificate: String? = null,
    @SerializedName("level") var level: Int? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("art_url") var artUrl: String? = null,
    @SerializedName("child_categories") var childCategories: String? = null,

    )