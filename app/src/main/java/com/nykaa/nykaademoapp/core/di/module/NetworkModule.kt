package com.nykaa.nykaademoapp.core.di.module

import com.google.gson.GsonBuilder
import com.nykaa.nykaademoapp.api.ApiConstant
import com.nykaa.nykaademoapp.api.ApiService
import com.nykaa.nykaademoapp.ui.productlist.paging.ProductPagingSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(ApiConstant.TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BASIC
            }).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl(ApiConstant.BASE_URL)
            //.addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun providesApiServices(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideProductPagingSource(api: ApiService): ProductPagingSource {
        return ProductPagingSource(api)
    }

}