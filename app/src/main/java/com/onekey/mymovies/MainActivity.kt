package com.onekey.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.onekey.mymovies.data.source.MoviesRepository
import com.onekey.mymovies.data.source.remote.MoviesRemoteDataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MoviesRepository(moviesRemoteDataSource = MoviesRemoteDataSource())
            .searchMovies(
                onSuccess = {
                    Log.d(TAG, "searchMovies, onSuccess")
                },
                onFailure = {
                    Log.d(TAG, "searchMovies, onFailure")
                }
            )
        MoviesRepository(moviesRemoteDataSource = MoviesRemoteDataSource())
            .getCurrentlyShowingMovies(
                onSuccess = {
                    Log.d(TAG, "getCurrentlyShowingMovies, onSuccess")
                },
                onFailure = {
                    Log.d(TAG, "getCurrentlyShowingMovies, onFailure")
                }
            )
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
