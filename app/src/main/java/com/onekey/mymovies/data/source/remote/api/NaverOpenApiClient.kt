package com.onekey.mymovies.data.source.remote.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NaverOpenApiClient {
    val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://openapi.naver.com/v1/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("EEE, dd MMM yyyy hh:mm:ss Z").create()
                )
            )
            .client(OkHttpClient())
            .build()
}
