package com.nykaa.nykaademoapp.core.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nykaa.nykaademoapp.core.di.annotations.ViewModelKey
import com.nykaa.nykaademoapp.data.repository.ProductRepo
import com.nykaa.nykaademoapp.data.viewmodelfactory.AppViewModelFactory
import com.nykaa.nykaademoapp.ui.productlist.ProductListViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun providesViewModelFactory(
        map: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
    ): ViewModelProvider.Factory {
        return AppViewModelFactory(map)
    }

    @Provides
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    fun providesRepositoriesViewModel(repository: ProductRepo): ViewModel {
        return ProductListViewModel(repository)
    }


}