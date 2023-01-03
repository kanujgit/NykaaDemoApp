package com.nykaa.nykaademoapp.data.model

import com.google.gson.annotations.SerializedName


data class Products(

    @SerializedName("rating") var rating: String? = null,
    @SerializedName("is_kit_combo") var isKitCombo: String? = null,
    @SerializedName("object_type") var objectType: String? = null,
    @SerializedName("is_saleable") var isSaleable: Boolean? = null,
    @SerializedName("explore_more") var exploreMore: String? = null,
    @SerializedName("pack_size") var packSize: String? = null,
    @SerializedName("category_ids") var categoryIds: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("sku") var sku: String? = null,
    @SerializedName("rating_count") var ratingCount: String? = null,
    @SerializedName("from_gludo") var fromGludo: Int? = null,
    @SerializedName("fbn") var fbn: Int? = null,
    @SerializedName("gludo_stock") var gludoStock: Boolean? = null,
    @SerializedName("offers") var offers: String? = null,
    @SerializedName("mrp_freeze") var mrpFreeze: String? = null,
    @SerializedName("primary_categories") var primaryCategories: PrimaryCategories? = PrimaryCategories(),
    @SerializedName("type") var type: String? = null,
    @SerializedName("final_price") var finalPrice: Int? = null,
    @SerializedName("expdt") var expdt: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("button_text") var buttonText: String? = null,
    @SerializedName("brand_name") var brandName: String? = null,
    @SerializedName("discount") var discount: Int? = null,
    @SerializedName("show_wishlist_button") var showWishlistButton: Int? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("is_lux") var isLux: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("pro_flag") var proFlag: Int? = null,
    @SerializedName("dynamic_tags") var dynamicTags: ArrayList<String> = arrayListOf(),
    @SerializedName("brand_ids") var brandIds: String? = null,
    @SerializedName("is_backorder") var isBackorder: Int? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("catalog_tag") var catalogTag: ArrayList<String> = arrayListOf(),
    @SerializedName("quantity") var quantity: Int? = null,

    )