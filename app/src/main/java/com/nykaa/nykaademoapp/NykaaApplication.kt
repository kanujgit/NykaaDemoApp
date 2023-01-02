package com.nykaa.nykaademoapp

import android.app.Application
import com.nykaa.nykaademoapp.core.logger.DefaultTree
import timber.log.Timber

class NykaaApplication : Application() {

    companion object {
        lateinit var instance: NykaaApplication
        fun get(): NykaaApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(object : DefaultTree() {})
        }
    }
}