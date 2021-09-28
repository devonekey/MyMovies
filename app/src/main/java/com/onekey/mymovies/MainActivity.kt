package com.onekey.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NaverOpenApiClient.retrofit
            .create(OpenApi::class.java)
            .searchMovies(
                clientId = BuildConfig.NAVER_CLIENT_ID,
                clientSecret = BuildConfig.NAVER_CLIENT_SECRET,
                query = "보스 베이비 2",
                display = 1,
                start = 1
            )
            .enqueue(object : Callback<MoviesResult.ForOpenApi> {
                override fun onResponse(
                    call: Call<MoviesResult.ForOpenApi>,
                    response: Response<MoviesResult.ForOpenApi>
                ) {
                    Log.d(TAG, "onResponse\nurl : ${call.request().url}")
                }

                override fun onFailure(call: Call<MoviesResult.ForOpenApi>, t: Throwable) {
                    Log.d(TAG, "onFailure\nurl : ${call.request().url}")
                }
            })
        NaverMobileApiClient.retrofit
            .create(MobileApi::class.java)
            .getCurrentlyShowingMovies()
            .enqueue(object : Callback<MoviesResult.ForMobileApi> {
                override fun onResponse(
                    call: Call<MoviesResult.ForMobileApi>,
                    response: Response<MoviesResult.ForMobileApi>
                ) {
                    Log.d(TAG, "onResponse\nurl : ${call.request().url}")
                }

                override fun onFailure(
                    call: Call<MoviesResult.ForMobileApi>,
                    t: Throwable
                ) {
                    Log.d(TAG, "onFailure\nurl : ${call.request().url}")
                }
            })
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
