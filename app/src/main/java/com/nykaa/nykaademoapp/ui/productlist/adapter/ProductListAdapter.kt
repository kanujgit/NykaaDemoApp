package com.nykaa.nykaademoapp.ui.productlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nykaa.nykaademoapp.R
import com.nykaa.nykaademoapp.data.model.Products
import com.nykaa.nykaademoapp.databinding.PrdListItemBinding

class ProductListAdapter(
    private val prdList: List<Products>,
    private val onPressButton: (Products, View) -> Unit,
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {


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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: PrdListItemBinding =
            PrdListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(prdList[position])
    }

    override fun getItemCount(): Int = prdList.size

}