package com.onekey.mymovies.data.source.remote.api

import com.onekey.mymovies.BuildConfig
import com.onekey.mymovies.data.MoviesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface OpenApi {
    @GET("search/movie.json")
    fun searchMovies(
        @Header("X-Naver-Client-Id") clientId: String = BuildConfig.NAVER_CLIENT_ID,
        @Header("X-Naver-Client-Secret") clientSecret: String = BuildConfig.NAVER_CLIENT_SECRET,
        @Query("query") query: String,
        @Query("display") display: Int,
        @Query("start") start: Int
    ): Call<MoviesResult.ForOpenApi>
}
