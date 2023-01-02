package com.nykaa.nykaademoapp.ui.productlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nykaa.nykaademoapp.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}