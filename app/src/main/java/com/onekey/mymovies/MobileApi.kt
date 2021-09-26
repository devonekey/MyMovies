package com.onekey.mymovies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MobileApi {
    @GET("p/csearch/content/qapirender.nhn")
    fun getCurrentlyShowingMovies(
        @Query("where") where: String = "nexearch",
        @Query("start") start: Int = 0,
        @Query("display") display: Int = 100,
        @Query("q") q: String = "현재상영영화"
    ): Call<MoviesResult.ForMobileApi>
}
