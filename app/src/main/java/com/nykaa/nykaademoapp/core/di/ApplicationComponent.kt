package com.nykaa.nykaademoapp.core.di

import android.content.Context
import com.nykaa.nykaademoapp.core.di.module.NetworkModule
import com.nykaa.nykaademoapp.core.di.module.ViewModelModule
import com.nykaa.nykaademoapp.core.di.subcomponent.DashboardComponent
import com.nykaa.nykaademoapp.ui.productlist.ProductListActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, SubComponentsModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun addDashboardComponent(): DashboardComponent.Factory

    fun inject(activity: ProductListActivity?)

}

@Module(subcomponents = [DashboardComponent::class])
object SubComponentsModule