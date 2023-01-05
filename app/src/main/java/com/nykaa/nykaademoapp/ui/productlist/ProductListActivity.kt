package com.nykaa.nykaademoapp.ui.productlist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nykaa.nykaademoapp.core.di.subcomponent.DashboardComponent
import com.nykaa.nykaademoapp.core.getAppComponent
import com.nykaa.nykaademoapp.core.hide
import com.nykaa.nykaademoapp.core.show
import com.nykaa.nykaademoapp.databinding.ActivityProductListBinding
import com.nykaa.nykaademoapp.ui.productlist.adapter.ProductListAdapter
import com.nykaa.nykaademoapp.ui.productlist.adapter.ProductLoadStateAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    lateinit var dashboardComponent: DashboardComponent

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ProductListViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardComponent = getAppComponent().addDashboardComponent().create()
        getAppComponent().inject(this)

        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init product list adapter
        val prdAdapter = ProductListAdapter()
        val gridLayoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)


        binding.recPrdList.apply {
            layoutManager = gridLayoutManager
            adapter = prdAdapter
        }

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val viewType = prdAdapter.getItemViewType(position)
                return if (viewType == ProductListAdapter.LOADING_ITEM) 1
                else 2
            }
        }
        prdAdapter.addLoadStateListener { loadState ->
            // show empty list
            if (loadState.refresh is LoadState.Loading) {
                binding.progressBar.show()
            } else {
                binding.progressBar.hide()
                val errorState = when {
                    loadState.append is LoadState.Error -> {
                        Timber.e("error state ")
                        loadState.append as LoadState.Error

                    }
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    Timber.e("error in loading ${errorState.error.message}")
                }

            }
        }

        // load more view
        binding.recPrdList.adapter =
            prdAdapter.withLoadStateHeaderAndFooter(header = ProductLoadStateAdapter { prdAdapter.retry() },
                footer = ProductLoadStateAdapter { prdAdapter.retry() })

        // callback for collecting latest data
        lifecycleScope.launch {
            viewModel.productListing().collectLatest {
                prdAdapter.submitData(lifecycle, it)
            }
        }
    }
}