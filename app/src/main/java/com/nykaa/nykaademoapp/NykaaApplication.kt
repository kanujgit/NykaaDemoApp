package com.nykaa.nykaademoapp

import android.app.Application
import com.nykaa.nykaademoapp.core.di.ApplicationComponent
import com.nykaa.nykaademoapp.core.di.DaggerApplicationComponent
import com.nykaa.nykaademoapp.core.logger.DefaultTree
import timber.log.Timber

class NykaaApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    companion object {
        lateinit var instance: NykaaApplication
        fun get(): NykaaApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(object : DefaultTree() {})
        }
    }
}