package com.onekey.mymovies.data.source.remote.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NaverMobileApiClient {
    val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://m.search.naver.com/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy.MM.dd.").create()
                )
            )
            .client(OkHttpClient())
            .build()
}
