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
                clientId = getString(R.string.naver_client_id),
                clientSecret = getString(R.string.naver_client_secret),
                query = "보스 베이비 2",
                display = 1,
                start = 1
            )
            .enqueue(object : Callback<MoviesResult> {
                override fun onResponse(
                    call: Call<MoviesResult>,
                    response: Response<MoviesResult>
                ) {
                    Log.d(TAG, "onResponse\nurl : ${call.request().url}")
                }

                override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
                    Log.d(TAG, "onFailure\nurl : ${call.request().url}")
                }
            })
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
