package com.nykaa.nykaademoapp.ui.productlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nykaa.nykaademoapp.data.model.Response
import com.nykaa.nykaademoapp.databinding.PrdListItemBinding

class ProductListAdapter(
    private val prdList: List<Response>,
    private val onRepoPress: (Response, View) -> Unit,
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    class ViewHolder(private val itemViewBinding: PrdListItemBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(data: Response) {


//            Picasso.get().load(data.owner?.avatar_url).transform(CircleTransform())
//                .into(itemViewBinding.ivUserImage)
//
//            itemView.setOnClickListener { onRepoPress.invoke(data, itemView) }
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