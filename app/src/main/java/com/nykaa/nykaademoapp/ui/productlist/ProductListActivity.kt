package com.nykaa.nykaademoapp.ui.productlist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nykaa.nykaademoapp.api.ApiState
import com.nykaa.nykaademoapp.core.di.subcomponent.DashboardComponent
import com.nykaa.nykaademoapp.core.getAppComponent
import com.nykaa.nykaademoapp.core.hide
import com.nykaa.nykaademoapp.core.show
import com.nykaa.nykaademoapp.data.model.Products
import com.nykaa.nykaademoapp.data.model.Response
import com.nykaa.nykaademoapp.databinding.ActivityProductListBinding
import com.nykaa.nykaademoapp.ui.productlist.adapter.ProductListAdapter
import timber.log.Timber
import javax.inject.Inject

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    lateinit var dashboardComponent: DashboardComponent

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ProductListViewModel by viewModels { viewModelFactory }

    private var productList = mutableListOf<Products>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardComponent = getAppComponent().addDashboardComponent().create()
        getAppComponent().inject(this)

        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val prdAdapter = ProductListAdapter(productList) { repoData, sharedView ->
            Timber.d("click")
        }
        binding.recPrdList.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        binding.recPrdList.adapter = prdAdapter


        lifecycleScope.launchWhenCreated {
            viewModel.onProductData.collect {
                Timber.d("data : $it")
                when (it) {
                    is ApiState.Loading -> loadingState()
                    is ApiState.Failure -> {
                        Timber.d("data : $it")
                        failState()
                    }
                    is ApiState.Success -> {
                        Timber.d("data : ${it.data}")

                        val res = it.data as Response
                        Timber.d("res $res")
                        binding.lottieAnimation.hide()
                        binding.progressBar.hide()
                        productList.clear()
                        productList.addAll(res.products)
                        prdAdapter.notifyDataSetChanged()
                        Timber.d("product list : $productList")
                    }
                    is ApiState.Empty -> {
                        Timber.d("empty .... ")
                    }
                }
            }
        }
    }

    private fun failState() {
        binding.progressBar.hide()
        binding.lottieAnimation.show()
        binding.lottieAnimation.playAnimation()
    }

    private fun loadingState() {
        binding.lottieAnimation.hide()
        binding.lottieAnimation.cancelAnimation()
        binding.progressBar.show()
    }
}