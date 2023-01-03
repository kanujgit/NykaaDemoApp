package com.nykaa.nykaademoapp.core.di.subcomponent

import com.nykaa.nykaademoapp.core.di.annotations.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface DashboardComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DashboardComponent
    }

//    fun inject(fragment: FragmentName )


}