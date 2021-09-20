package com.onekey.mymovies.data.source.remote

import android.util.Log
import com.onekey.mymovies.data.Movie
import com.onekey.mymovies.data.MoviesResult
import com.onekey.mymovies.data.source.MoviesDataSource
import com.onekey.mymovies.data.source.remote.api.MobileApi
import com.onekey.mymovies.data.source.remote.api.NaverMobileApiClient
import com.onekey.mymovies.data.source.remote.api.NaverOpenApiClient
import com.onekey.mymovies.data.source.remote.api.OpenApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRemoteDataSource : MoviesDataSource {
    override fun searchMovies(
        onSuccess: ((List<Movie?>?) -> Unit),
        onFailure: ((String?) -> Unit)
    ) {
        NaverOpenApiClient.retrofit
            .create(OpenApi::class.java)
            .searchMovies(query = "보스 베이비 2", display = 1, start = 1)
            .enqueue(object : Callback<MoviesResult.ForOpenApi> {
                override fun onResponse(
                    call: Call<MoviesResult.ForOpenApi>,
                    response: Response<MoviesResult.ForOpenApi>
                ) {
                    Log.d(TAG, "onResponse\nurl : ${call.request().url}")

                    onSuccess.invoke((response.body() as MoviesResult).items)
                }

                override fun onFailure(call: Call<MoviesResult.ForOpenApi>, t: Throwable) {
                    Log.d(TAG, "onFailure\nurl : ${call.request().url}")

                    onFailure.invoke(t.message)
                }
            })
    }

    override fun getCurrentlyShowingMovies(
        onSuccess: ((List<Movie?>?) -> Unit),
        onFailure: ((String?) -> Unit)
    ) {
        NaverMobileApiClient.retrofit
            .create(MobileApi::class.java)
            .getCurrentlyShowingMovies()
            .enqueue(object : Callback<MoviesResult.ForMobileApi> {
                override fun onResponse(
                    call: Call<MoviesResult.ForMobileApi>,
                    response: Response<MoviesResult.ForMobileApi>
                ) {
                    Log.d(TAG, "onResponse\nurl : ${call.request().url}")

                    onSuccess.invoke((response.body() as MoviesResult).items)
                }

                override fun onFailure(
                    call: Call<MoviesResult.ForMobileApi>,
                    t: Throwable
                ) {
                    Log.d(TAG, "onFailure\nurl : ${call.request().url}")

                    onFailure.invoke(t.message)
                }
            })
    }

    companion object {
        val TAG: String = MoviesRemoteDataSource::class.java.simpleName
    }
}
