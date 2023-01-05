package com.nykaa.nykaademoapp.ui.productlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nykaa.nykaademoapp.R
import com.nykaa.nykaademoapp.data.model.Products
import com.nykaa.nykaademoapp.databinding.PrdListItemBinding

class ProductListAdapter :
    PagingDataAdapter<Products, ProductListAdapter.ViewHolder>(ProductComparator) {

    // Define Loading ViewType
    companion object {
        const val LOADING_ITEM: Int = 0
        const val PRODUCT_LIST_ITEM: Int = 1
    }


    class ViewHolder(private val binding: PrdListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Products) {
            Glide.with(itemView).load(data.imageUrl).placeholder(R.drawable.dummy_prd).dontAnimate()
                .into(binding.prdImg)
            binding.tvPrdPrice.text = binding.root.context.resources.getString(R.string.inr_symbol,
                data.finalPrice.toString())

            binding.ratingPrd.rating = (data.rating?.toFloat() ?: "") as Float
            binding.tvRatingCount.text =
                binding.root.context.resources.getString(R.string.small_bracket, data.ratingCount)
            binding.tvPrd.text = data.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position === itemCount) PRODUCT_LIST_ITEM else LOADING_ITEM

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: PrdListItemBinding =
            PrdListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    object ProductComparator : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(oldItem: Products, newItem: Products) =
            (oldItem.id == newItem.id)

        override fun areContentsTheSame(oldItem: Products, newItem: Products) = (oldItem == newItem)
    }
}