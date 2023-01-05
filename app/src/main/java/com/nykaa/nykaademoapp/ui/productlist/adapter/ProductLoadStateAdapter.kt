package com.nykaa.nykaademoapp.ui.productlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nykaa.nykaademoapp.core.hide
import com.nykaa.nykaademoapp.core.visible
import com.nykaa.nykaademoapp.databinding.ItemLoadingStateBinding
import timber.log.Timber

class ProductLoadStateAdapter(
    private val retry: () -> Unit,
) : LoadStateAdapter<ProductLoadStateAdapter.ProductLoadViewHolder>() {

    inner class ProductLoadViewHolder(
        private val binding: ItemLoadingStateBinding,
        private val retry: () -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.tvItemCount.text = "No More Data"
                Timber.d("Error  state")
                binding.progressBar.hide()
            }

            binding.progressBar.visible(loadState is LoadState.Loading)
            binding.tvItemCount.visible(loadState is LoadState.Error)

            // TODO impl later
            binding.buttonRetry.setOnClickListener {
                //  retry()
            }

        }
    }

    override fun onBindViewHolder(holder: ProductLoadViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState,
    ) = ProductLoadViewHolder(ItemLoadingStateBinding.inflate(LayoutInflater.from(parent.context),
        parent,
        false), retry)
}

